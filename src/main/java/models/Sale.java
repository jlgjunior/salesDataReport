package models;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	
	private Integer id;
	private List<Product> products = new ArrayList<Product>();

	public Sale(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public List<Product> getProducts() {
		return this.products ;
	}

}
