package builders;

import models.Product;


public class ProductBuilder {

	private Long id;
	private Integer quantity = 0;
	private Float price = 0F;
	
	public ProductBuilder() {
		
	}

	public Product build() {
		return new Product(this);
	}
	
	public ProductBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public Long getId() {
		return id;
	}

	public ProductBuilder setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public ProductBuilder setPrice(Float price) {
		this.price = price;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Float getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}
