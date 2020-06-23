package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.Customer;
import models.Person;
import models.Salesperson;
import models.Sale;

public class SalespersonTest {

	@Test
	//Checks if getName returns assigned name
	public void getNameTest() {
		String name = "John";
		Person person = new Salesperson(name);
		assertEquals(name, person.getName());
	}

	@Test
	//Checks if salesperson sales list is a list of sales
	public void getSalesTest() {
		String name = "John";
		Salesperson salesperson = new Salesperson(name);
		salesperson.getSales().add(new Sale());
		assertEquals(salesperson.getSales().get(0).getClass(), Sale.class);
	}
	
	@Test
	//Checks if new salesperson sales list is empty
	public void getSalesEmptyTest() {
		String name = "John";
		Salesperson salesperson = new Salesperson(name);
		assertTrue(salesperson.getSales().isEmpty());
	}
	
}
