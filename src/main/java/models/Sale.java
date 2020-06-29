package models;

import java.util.ArrayList;
import java.util.List;

import builders.SaleBuilder;

public class Sale implements PersistantModel {
	
	private Long id;
	private Float saleValue;
	private List<Product> products;

	public Sale() {
		products = new ArrayList<Product>();
	}
	
	public Sale(SaleBuilder saleBuilder) {
		id = saleBuilder.getId();
		saleValue = saleBuilder.getSaleValue();
		products = saleBuilder.getProducts();
	}

	public Long getId() {
		return id;
	}

	public List<Product> getProducts() {
		return products ;
	}

	@Override
	public void loadCSVData(CSVData data) {
		// TODO Auto-generated method stub
		
	}

	public Float getSaleValue() {
		return saleValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((saleValue == null) ? 0 : saleValue.hashCode());
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
		if (saleValue == null) {
			if (other.saleValue != null)
				return false;
		} else if (!saleValue.equals(other.saleValue))
			return false;
		return true;
	}
}
