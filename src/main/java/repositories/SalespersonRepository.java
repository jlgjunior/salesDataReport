package repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import models.Salesperson;

@Repository
public interface SalespersonRepository extends CrudRepository<Salesperson, Long> {

	public List<Salesperson> findByName(String name);
	
}
