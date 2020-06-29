package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Customer;


public class CustomerRepository implements IRepository<Customer> {

	List<Customer> customers = new ArrayList<Customer>();
	
	public CustomerRepository() {
		
	}
	
	@Override
	public Customer save(Customer entity) {
		customers.add(entity);
		return entity;
	}

}