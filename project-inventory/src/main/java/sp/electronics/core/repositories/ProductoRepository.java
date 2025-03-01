package sp.electronics.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sp.electronics.core.models.ProductoEntity;

public interface ProductoRepository extends CrudRepository<ProductoEntity,Integer>{
    
    @Query("SELECT p FROM ProductoEntity p ORDER BY " +
           "SUBSTRING(p.proCodigo, 1, 1) ASC, " + 
           "CAST(SUBSTRING(p.proCodigo, 2, LOCATE('-', p.proCodigo) - 2) AS int) ASC, " +
           "CAST(SUBSTRING(p.proCodigo, LOCATE('-', p.proCodigo) + 1) AS int) ASC")
    List<ProductoEntity> findAllOrdenado();
}
