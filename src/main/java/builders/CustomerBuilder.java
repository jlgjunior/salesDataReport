package builders;

import models.Customer;

public class CustomerBuilder {
	
	private String name = "None";
	private String cnpj = "None";
	private String area = "None";
	
	public CustomerBuilder() {
		
	}

	public Customer build() {
		return new Customer(this);
	}
	
	public CustomerBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public CustomerBuilder setCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}
	
	public CustomerBuilder setArea(String area) {
		this.area = area;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getArea() {
		return area;
	}
}
