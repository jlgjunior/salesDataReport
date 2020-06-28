package builders;

import models.Product;
import models.SaleProduct;

public class SaleProductBuilder {

	private Integer quantity;
	private Float price;
	private Product product;
	
	public SaleProductBuilder() {
		
	}

	public SaleProduct build() {
		return new SaleProduct(this);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public SaleProductBuilder setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Float getPrice() {
		return price;
	}

	public SaleProductBuilder setPrice(Float price) {
		this.price = price;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public SaleProductBuilder setProduct(Product product) {
		this.product = product;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		SaleProductBuilder other = (SaleProductBuilder) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
}
