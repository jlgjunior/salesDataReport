package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import builders.SaleBuilder;

@Entity
public class Sale implements PersistantModel {
	
	@Id
	private Long id;
	private List<SaleProduct> saleProducts;

	public Sale() {
		saleProducts = new ArrayList<SaleProduct>();
	}
	
	public Sale(SaleBuilder saleBuilder) {
		id = saleBuilder.getId();
		saleProducts = saleBuilder.getSaleProducts();
	}

	public Long getId() {
		return this.id;
	}

	public List<SaleProduct> getSaleProducts() {
		return this.saleProducts ;
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
		Sale other = (Sale) obj;
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

	@Override
	public void loadCSVData(CSVData data) {
		// TODO Auto-generated method stub
		
	}
}
