package sp.electronics.core.services.sevices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp.electronics.core.models.CategoriaEntity;
import sp.electronics.core.repositories.CategoriasRepository;
import sp.electronics.core.services.DTO.CategoriaDTO;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
    @Autowired
    private CategoriasRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CategoriaDTO> finAll() {
      Iterable<CategoriaEntity> ListaCategoriasEntity = this.servicioAccesoBaseDatos.findAll();
      System.out.println( "antes de la consulta");
      List<CategoriaDTO> objCategoriaDTO = this.modelMapper.map(ListaCategoriasEntity, new TypeToken<List<CategoriaDTO>>(){}.getType());
      return objCategoriaDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaDTO finById(Integer id) {
        Optional<CategoriaEntity> optional = this.servicioAccesoBaseDatos.findById(id); //el opcional puede quedar vacio y no generara  nullpointerExcepcion
        CategoriaEntity user = optional.get();
        System.out.println("antes de la consulta");
        CategoriaDTO categoriaDTO = this.modelMapper.map(user, CategoriaDTO.class);
        return categoriaDTO;
    }

    @Override
    @Transactional()
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoriaEntity = this.modelMapper.map(categoriaDTO,CategoriaEntity.class);
        CategoriaEntity objCategoriaEntity = this.servicioAccesoBaseDatos.save(categoriaEntity);
        CategoriaDTO objCategoriaDTO = this.modelMapper.map(objCategoriaEntity, CategoriaDTO.class);
        return objCategoriaDTO;
    }

    @Override
    @Transactional()
    public CategoriaDTO update(Integer id, CategoriaDTO categoria) {
        Optional <CategoriaEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        CategoriaEntity objCategoriaEntity = optional.get();

        CategoriaDTO objCategoriaDTOActualizado = null;
        if(objCategoriaEntity != null){
            CategoriaEntity categoriaEntity = this.modelMapper.map(categoria, CategoriaEntity.class);
            CategoriaEntity objCategoriaEntityActualizado = this.servicioAccesoBaseDatos.save(categoriaEntity);
            objCategoriaDTOActualizado = this.modelMapper.map(objCategoriaEntityActualizado, CategoriaDTO.class);
        }
        
        return objCategoriaDTOActualizado;
    }

    /* 
    @Override
    @Transactional(readOnly = true)
    public boolean delete(Integer id) {
        boolean bandera = false; 
        Optional <ImpuestoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        ImpuestoEntity user = optional.get();

        if (user != null) {
            this.servicioAccesoBaseDatos.delete(user);
            bandera = true;
        }
        return bandera;
    }
        */
    @Override
    @Transactional(readOnly = true)
    public boolean delete(Integer id) {
        boolean bandera = false; 
        Optional <CategoriaEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        CategoriaEntity user = optional.get();

        if (user != null) {
            this.servicioAccesoBaseDatos.delete(user);
            bandera = true;
        }
        return bandera;
    }
}
