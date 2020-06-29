package repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Salesperson;

public class SalespersonRepository implements IRepository<Salesperson> {

	public Map<String, Salesperson> salespeople = 
                       			new HashMap<String, Salesperson>();

	
	public SalespersonRepository() {
		
	}
	
	@Override
	public Salesperson save(Salesperson entity) {
		salespeople.putIfAbsent(entity.getName(), entity);
		return entity;
	}

	@Override
	public List<Salesperson> findAll() {
		return new ArrayList<Salesperson>(salespeople.values());
	}

	@Override
	public void clear() {
		salespeople.clear();
	}
	
}
