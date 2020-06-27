package models;

public class Customer extends Person implements PersistantModel <CSVCustomerData>{

	private String cnpj;
	private String area;
	
	public Customer() {
		
	}

	@Override
	public void loadCSVData(CSVCustomerData data) {
		this.area = data.getArea();
		this.name = data.getName();
		this.cnpj = data.getCnpj();
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getArea() {
		return area;
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
