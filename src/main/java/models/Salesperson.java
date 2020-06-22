package models;

import java.util.ArrayList;
import java.util.List;

public class Salesperson extends Person {

	private List<Object> sales = new ArrayList();

	public Salesperson(String name) {
		super(name);
	}

	public List<Object> getSales() {
		return this.sales ;
	}

}
