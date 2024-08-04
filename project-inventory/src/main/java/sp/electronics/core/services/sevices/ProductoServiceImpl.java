package sp.electronics.core.services.sevices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import sp.electronics.core.models.ProductoEntity;
import sp.electronics.core.repositories.ProductoRepository;
import sp.electronics.core.services.DTO.ProductoDTO;

public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ProductoDTO> finAll() {
      Iterable<ProductoEntity> ListaProductoEntity = this.servicioAccesoBaseDatos.findAll();
      System.out.println( "antes de la consulta");
      List<ProductoDTO> objProductosDTO = this.modelMapper.map(ListaProductoEntity, new TypeToken<List<ProductoDTO>>(){}.getType());
      return objProductosDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO finById(Integer id) {
        Optional<ProductoEntity> optional = this.servicioAccesoBaseDatos.findById(id); //el opcional puede quedar vacio y no generara  nullpointerExcepcion
        ProductoEntity user = optional.get();
        System.out.println("antes de la consulta");
        ProductoDTO productoDTO = this.modelMapper.map(user, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    @Transactional()
    public ProductoDTO save(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = this.modelMapper.map(productoDTO,ProductoEntity.class);
        ProductoEntity objProductoEntity = this.servicioAccesoBaseDatos.save(productoEntity);
        ProductoDTO objProductoDTO = this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return objProductoDTO;
    }

    @Override
    @Transactional()
    public ProductoDTO update(Integer id, ProductoDTO producto) {
        Optional <ProductoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        ProductoEntity objProductoEntity = optional.get();

        ProductoDTO objProductoDTOActualizado = null;
        if(objProductoEntity != null){
            ProductoEntity productoEntity = this.modelMapper.map(producto, ProductoEntity.class);
            ProductoEntity objProductoEntityActualizado = this.servicioAccesoBaseDatos.save(productoEntity);
            objProductoDTOActualizado = this.modelMapper.map(objProductoEntityActualizado, ProductoDTO.class);
        }
        
        return objProductoDTOActualizado;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean delete(Integer id) {
        boolean bandera = false; 
        Optional <ProductoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        ProductoEntity user = optional.get();

        if (user != null) {
            this.servicioAccesoBaseDatos.delete(user);
            bandera = true;
        }
        return bandera;
    }
    
}
