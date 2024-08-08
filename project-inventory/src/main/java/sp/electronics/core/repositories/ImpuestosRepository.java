package sp.electronics.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sp.electronics.core.models.ImpuestoEntity;

@Repository
public interface ImpuestosRepository extends CrudRepository<ImpuestoEntity,Integer> {
    
}
