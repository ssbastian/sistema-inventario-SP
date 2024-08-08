package sp.electronics.core.services.sevices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sp.electronics.core.models.ImpuestoEntity;
import sp.electronics.core.repositories.ImpuestosRepository;
import sp.electronics.core.services.DTO.ImpuestoDTO;

@Service
public class ImpuestoServiceImpl implements IImpuestoService{
   @Autowired
    private ImpuestosRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ImpuestoDTO> finAll() {
      Iterable<ImpuestoEntity> ListaImpuestosEntity = this.servicioAccesoBaseDatos.findAll();
      System.out.println( "antes de la consulta");
      List<ImpuestoDTO> objImpuestoDTO = this.modelMapper.map(ListaImpuestosEntity, new TypeToken<List<ImpuestoDTO>>(){}.getType());
      return objImpuestoDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public ImpuestoDTO finById(Integer id) {
        Optional<ImpuestoEntity> optional = this.servicioAccesoBaseDatos.findById(id); //el opcional puede quedar vacio y no generara  nullpointerExcepcion
        ImpuestoEntity user = optional.get();
        System.out.println("antes de la consulta");
        ImpuestoDTO impuestoDTO = this.modelMapper.map(user, ImpuestoDTO.class);
        return impuestoDTO;
    }

    @Override
    @Transactional()
    public ImpuestoDTO save(ImpuestoDTO impuestoDTO) {
        ImpuestoEntity impuestoEntity = this.modelMapper.map(impuestoDTO,ImpuestoEntity.class);
        ImpuestoEntity objImpuestoEntity = this.servicioAccesoBaseDatos.save(impuestoEntity);
        ImpuestoDTO objImpuestoDTO = this.modelMapper.map(objImpuestoEntity, ImpuestoDTO.class);
        return objImpuestoDTO;
    }

    @Override
    @Transactional()
    public ImpuestoDTO update(Integer id, ImpuestoDTO impuesto) {
        Optional <ImpuestoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        ImpuestoEntity objImpuestoEntity = optional.get();

        ImpuestoDTO objImpuestoDTOActualizado = null;
        if(objImpuestoEntity != null){
            ImpuestoEntity impuestoEntity = this.modelMapper.map(impuesto, ImpuestoEntity.class);
            ImpuestoEntity objImpuestoEntityActualizado = this.servicioAccesoBaseDatos.save(impuestoEntity);
            objImpuestoDTOActualizado = this.modelMapper.map(objImpuestoEntityActualizado, ImpuestoDTO.class);
        }
        
        return objImpuestoDTOActualizado;
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
    @Transactional(readOnly = false)
    public boolean delete(Integer id) {
        boolean bandera = false; 
        Optional <ImpuestoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        ImpuestoEntity user = optional.get();
        System.out.println("aca esta----------------");
        System.out.println(user = optional.get());
        System.out.println(id);
        System.out.println(bandera);
        System.out.println("------------");

        if (user != null) {
            this.servicioAccesoBaseDatos.delete(user);
            bandera = true;
        }
        return bandera;
    }
}
