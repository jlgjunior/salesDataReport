package models;

public class CSVSalespersonData implements CSVData {

	private String cpf;
	private String name;
	private float salary;
	
	public CSVSalespersonData() {

	}
	
	public CSVSalespersonData(String cpf, String name, float salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public boolean loadData(String[] data) {
		try {
			this.cpf = data[1];
			this.name = data[2];
			this.salary = Float.valueOf(data[3]);
			return true;
		}
		catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
			return false;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public float getSalary() {
		return salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
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
		CSVSalespersonData other = (CSVSalespersonData) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		return true;
	}
	
	

}
