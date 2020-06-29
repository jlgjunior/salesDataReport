package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import builders.SaleProductBuilder;

@Entity
public class SaleProduct implements PersistantModel {

	@Id
	@GeneratedValue
	private Long id;
	private Float price;
	private Integer quantity;
	@ManyToOne
	@JoinColumn(name="sale_id")
	private Sale sale;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	public SaleProduct(SaleProductBuilder saleProductBuilder) {
		price = saleProductBuilder.getPrice();
		quantity = saleProductBuilder.getQuantity();
		product = saleProductBuilder.getProduct();
	}

	public SaleProduct() {

	}

	@Override
	public void loadCSVData(CSVData data) {
		
	}

	public Sale getSale() {
		return sale;
	}

	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public Float getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
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
		SaleProduct other = (SaleProduct) obj;
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
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		return true;
	}

}
