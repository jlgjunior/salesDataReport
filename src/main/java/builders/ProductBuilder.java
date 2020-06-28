package builders;

import models.Product;


public class ProductBuilder {

	private Integer id;
	
	public ProductBuilder() {
		
	}

	public Product build() {
		return new Product(this);
	}
	
	public ProductBuilder setId(Integer id) {
		this.id = id;
		return this;
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProductBuilder other = (ProductBuilder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
