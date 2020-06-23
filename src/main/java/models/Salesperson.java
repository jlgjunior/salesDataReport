package models;

import java.util.ArrayList;
import java.util.List;

public class Salesperson extends Person {

	private List<Sale> sales = new ArrayList<Sale>();

	public Salesperson(String name) {
		super(name);
	}

	public List<Sale> getSales() {
		return this.sales ;
	}

	public void addSale(Sale sale) {
		this.sales.add(sale);
	}

}
