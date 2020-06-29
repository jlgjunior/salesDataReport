package builders;

import java.util.ArrayList;
import java.util.List;

import models.Product;
import models.Sale;


public class SaleBuilder {

	private Long id;
	private String salespersonName;
	private List<Product> products;
	private Float saleValue;
	
	public SaleBuilder() {
		this.products = new ArrayList<Product>();
	}

	public Sale build() {
		return new Sale(this);
	}
	
	public SaleBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public SaleBuilder setProducts(List<Product> products) {
		this.products = products;
		return this;
	}

	public Long getId() {
		return id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public SaleBuilder setSaleValue(Float saleValue) {
		this.saleValue = saleValue;
		return this;
	}

	public Float getSaleValue() {
		return saleValue;
	}

	public String getSalespersonName() {
		return salespersonName;
	}

	public SaleBuilder setSalespersonName(String salespersonName) {
		this.salespersonName = salespersonName;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((saleValue == null) ? 0 : saleValue.hashCode());
		result = prime * result + ((salespersonName == null) ? 0 : salespersonName.hashCode());
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
		SaleBuilder other = (SaleBuilder) obj;
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
		if (salespersonName == null) {
			if (other.salespersonName != null)
				return false;
		} else if (!salespersonName.equals(other.salespersonName))
			return false;
		return true;
	}
}
