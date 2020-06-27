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

}
