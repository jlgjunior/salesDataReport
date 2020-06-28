package models;

import java.util.ArrayList;
import java.util.List;

import builders.SaleBuilder;

public class Sale implements PersistantModel {
	
	private Integer id;
	private List<Product> products = new ArrayList<Product>();

	public Sale() {
		
	}
	
	public Sale(SaleBuilder saleBuilder) {
		id = saleBuilder.getId();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

	@Override
	public void loadCSVData(CSVData data) {
		// TODO Auto-generated method stub
		
	}
}
