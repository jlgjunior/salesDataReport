package models;

import java.util.Comparator;

import builders.CustomerBuilder;

public class Customer extends Person<Customer>{

	private String cnpj;
	private String area;
	
	public Customer() {
		name = "";
		cnpj = "";
		area = "";
	}

	public Customer(CustomerBuilder customerBuilder) {
		name = customerBuilder.getName();
		cnpj = customerBuilder.getCnpj();
		area = customerBuilder.getArea();
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getArea() {
		return area;
	}

	@Override
	public int compareTo(Customer anotherCustomer) {
		return cnpj.compareTo(anotherCustomer.getCnpj());
	}
	
	public static Comparator<Customer> getComparator() {
		return new Comparator<Customer>() {
            @Override
            public int compare(Customer customer1, Customer customer2) {
                return customer1.compareTo(customer2);
            }
        };
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

}
