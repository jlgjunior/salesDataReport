package builders;

import java.util.ArrayList;
import java.util.List;

import models.Sale;
import models.SaleProduct;


public class SaleBuilder {

	private Long id;
	private List<SaleProduct> saleProducts;
	
	public SaleBuilder() {
		this.saleProducts = new ArrayList<SaleProduct>();
	}

	public Sale build() {
		return new Sale(this);
	}
	
	public SaleBuilder setId(Long id) {
		this.id = id;
		return this;
	}
	
	public SaleBuilder setSaleProducts(List<SaleProduct> saleProducts) {
		this.saleProducts = saleProducts;
		return this;
	}

	public Long getId() {
		return id;
	}

	public List<SaleProduct> getSaleProducts() {
		return saleProducts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((saleProducts == null) ? 0 : saleProducts.hashCode());
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
		if (saleProducts == null) {
			if (other.saleProducts != null)
				return false;
		} else if (!saleProducts.equals(other.saleProducts))
			return false;
		return true;
	}
}
