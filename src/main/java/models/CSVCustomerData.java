package models;

public class CSVCustomerData implements CSVData {

	private String cnpj;
	private String name;
	private String area;
	
	public CSVCustomerData() {

	}

	public CSVCustomerData(String cnpj, String name, String area) {
		this.cnpj = cnpj;
		this.name = name;
		this.area = area;
	}

	@Override
	public boolean loadData(String[] data) {
		try {
			this.cnpj = data[1];
			this.name = data[2];
			this.area = data[3];
			return true;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getName() {
		return name;
	}

	public String getArea() {
		return area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CSVCustomerData other = (CSVCustomerData) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
