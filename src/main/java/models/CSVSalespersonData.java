package models;

public class CSVSalespersonData extends CSVData {

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
	
	public void loadData(String cpf, String name, String salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = Float.valueOf(salary);
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
