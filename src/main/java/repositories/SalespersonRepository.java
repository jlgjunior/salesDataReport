package repositories;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import models.Customer;
import models.Salesperson;

@Repository
public class SalespersonRepository implements IRepository<Salesperson> {

	public SortedSet<Salesperson> salespeople = 
                       			new TreeSet<Salesperson>(Salesperson.getComparator());

	
	public SalespersonRepository() {
		
	}
	
	@Override
	public Salesperson save(Salesperson entity) {
		salespeople.add(entity);
		return entity;
	}

	@Override
	public SortedSet<Salesperson> findAll() {
		return salespeople;
	}

	@Override
	public void reset() {
		salespeople = new TreeSet<Salesperson>(Salesperson.getComparator());
	}

	@Override
	public Salesperson saveToFile(Salesperson entity, String fileName) {
		return entity;
	}
}
