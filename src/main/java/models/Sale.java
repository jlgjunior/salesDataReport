package models;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	
	private Integer id;
	private List<Product> products = new ArrayList<Product>();

	public Sale() {
		
	}
	
	public Integer getId() {
		return this.id;
	}

	public List<Product> getProducts() {
		return this.products ;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

}
