package builders;

import models.Salesperson;

public class SalespersonBuilder {

	private String name;
	private String cpf;
	private Float salary;
	
	public SalespersonBuilder() {
		
	}

	public Salesperson build() {
		return new Salesperson(this);
	}
	
	public SalespersonBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public SalespersonBuilder setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public SalespersonBuilder setSalary(Float salary) {
		this.salary = salary;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Float getSalary() {
		return salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
		SalespersonBuilder other = (SalespersonBuilder) obj;
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
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}
}
