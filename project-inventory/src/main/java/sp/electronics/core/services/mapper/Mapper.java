package sp.electronics.core.services.mapper;

/* import org.modelmapper.ModelMapper; */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.modelmapper.ModelMapper;


@Configuration
public class Mapper {
    
    @Bean
    public ModelMapper ModelMapper(){
      ModelMapper objMapper = new ModelMapper();
    /*   TypeMap<ProductoEntity, ProductoDTO> mapa = objMapper.emptyTypeMap(ProductoEntity.class, ProductoDTO.class);
     
      mapa.addMappings(m -> m.skip(ProductoDTO::setCreateAt)).implicitMappings(); */ //no intente mapear un campo en particular desde el objeto de origen al objeto de destino.
      return objMapper;
    }

}
