package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import builders.ProductBuilder;

@Entity
public class Product {

	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name="sale_id")
	private Sale sale;
	
	public Product() {
		
	}

	public Product(ProductBuilder productBuilder) {
		id = productBuilder.getId();
	}

	public Long getId() {
		return this.id;
	}

	public Sale getSale() {
		return this.sale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		return true;
	}
}
