package repositories;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.stereotype.Repository;

import models.Customer;

@Repository
public class CustomerRepository implements IRepository<Customer> {

	SortedSet<Customer> customers = new TreeSet<Customer>(Customer.getComparator());
	
	public CustomerRepository() {
		
	}
	
	@Override
	public Customer save(Customer entity) {
		customers.add(entity);
		return entity;
	}

	@Override
	public SortedSet<Customer> findAll() {
		return customers;
	}

	@Override
	public void clear() {
		customers.clear();
	}

	@Override
	public Customer saveToFile(Customer entity, String fileName) {
		return entity;
	}

}