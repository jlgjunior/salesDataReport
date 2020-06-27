package models;

import java.util.ArrayList;
import java.util.List;

public class Salesperson extends Person implements PersistantModel<CSVSalespersonData> {

	private String cpf;
	private Float salary;
	private List<Sale> sales = new ArrayList<Sale>();

	public Salesperson() {

	}

	public String getCpf() {
		return cpf;
	}

	public Float getSalary() {
		return salary;
	}

	public List<Sale> getSales() {
		return this.sales ;
	}

	public void addSale(Sale sale) {
		this.sales.add(sale);
	}

	@Override
	public void loadCSVData(CSVSalespersonData data) {
		name = data.getName();
		cpf = data.getCpf();
		salary = data.getSalary();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
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
		Salesperson other = (Salesperson) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		return true;
	}

}
