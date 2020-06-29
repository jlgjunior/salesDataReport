package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import builders.SalespersonBuilder;

@Entity
public class Salesperson extends Person {

	@Id
	@GeneratedValue
	private Long id;
	private String cpf;
	private Float salary;
	@OneToMany
	@JoinColumn(name="salesperson_id")
	private List<Sale> sales = new ArrayList<Sale>();

	public Salesperson() {

	}

	public Salesperson(SalespersonBuilder salespersonBuilder) {
		cpf = salespersonBuilder.getCpf();
		name = salespersonBuilder.getName();
		salary = salespersonBuilder.getSalary();
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
	public void loadCSVData(CSVData data) {
		CSVSalespersonData salespersonData = (CSVSalespersonData) data;
		name = salespersonData.getName();
		cpf = salespersonData.getCpf();
		salary = salespersonData.getSalary();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
