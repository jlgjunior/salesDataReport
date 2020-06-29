package repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import models.Salesperson;

@Repository
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public interface SalespersonRepository extends CrudRepository<Salesperson, Long> {

	public List<Salesperson> findByName(String name);
	
}
