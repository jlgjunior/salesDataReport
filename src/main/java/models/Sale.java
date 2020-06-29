package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import builders.SaleBuilder;

public class Sale implements PersistantModel<Sale> {
	
	private Long id;
	private String salespersonName;
	private Float saleValue;
	private List<Product> products;

	public Sale() {
		salespersonName = "None";
		saleValue = 0F;
		products = new ArrayList<Product>();
	}
	
	public Sale(SaleBuilder saleBuilder) {
		id = saleBuilder.getId();
		salespersonName = saleBuilder.getSalespersonName();
		saleValue = saleBuilder.getSaleValue();
		products = saleBuilder.getProducts();
	}

	public Long getId() {
		return id;
	}

	public List<Product> getProducts() {
		return products ;
	}

	public Float getSaleValue() {
		return saleValue;
	}

	public String getSalespersonName() {
		return salespersonName;
	}
	

	@Override
	public int compareTo(Sale anotherSale) {
		int returnValue = saleValue.compareTo(anotherSale.getSaleValue());
		if (returnValue == 0) {
			return 1;
		}
		return returnValue;
	}
	
	//As you can see, the compareTo result is multiplied by
	//-1, since the values returned are 1, 0 and -1, and we
	//want the reverse order to be ordered from the most 
	//expensive sale to the cheapest one
	public static Comparator<Sale> getComparator() {
		return new Comparator<Sale>() {
            @Override
            public int compare(Sale sale1, Sale sale2) {
                return sale1.compareTo(sale2)*(-1);
            }
        };
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
		if (salespersonName == null) {
			if (other.salespersonName != null)
				return false;
		} else if (!salespersonName.equals(other.salespersonName))
			return false;
		return true;
	}
}
