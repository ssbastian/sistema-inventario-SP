package sp.electronics.core.repositories;

import org.springframework.data.repository.CrudRepository;

import sp.electronics.core.models.ProductoEntity;

public interface ProductoRepository extends CrudRepository<ProductoEntity,Integer>{
    
    
}
