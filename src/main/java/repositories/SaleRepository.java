package repositories;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import models.Sale;

@Repository
public class SaleRepository implements IRepository<Sale> {
	
	SortedSet<Sale> sales = new TreeSet<Sale>(Sale.getComparator());
	
	public SaleRepository() {
		
	}
	
	@Override
	public Sale save(Sale entity) {
		sales.add(entity);
		return entity;
	}

	@Override
	public SortedSet<Sale> findAll() {
		return sales;
	}

	@Override
	public void clear() {
		sales.clear();
	}

	@Override
	public Sale saveToFile(Sale entity, String fileName) {
		return entity;
	}

}
