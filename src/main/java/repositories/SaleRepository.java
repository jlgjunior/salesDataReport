package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Sale;

public class SaleRepository implements IRepository<Sale> {
	
	List<Sale> sales = new ArrayList<Sale>();
	
	public SaleRepository() {
		
	}
	
	@Override
	public Sale save(Sale entity) {
		sales.add(entity);
		return entity;
	}

	@Override
	public List<Sale> findAll() {
		return sales;
	}

	@Override
	public void clear() {
		sales.clear();
	}

}
