package builders;

import models.Sale;


public class SaleBuilder {

	private Integer id;
	private String products;
	
	public SaleBuilder() {
		
	}

	public Sale build() {
		return new Sale(this);
	}
	
	public SaleBuilder setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public SaleBuilder setProducts(String products) {
		this.products = products;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public String getProducts() {
		return products;
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
		return true;
	}
}
