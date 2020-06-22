package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import models.Customer;
import models.Person;
import models.Salesperson;

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
		assertEquals(salesperson.getSales().getClass(), List<Sale>);
	}
	
	@Test
	//Checks if new salesperson sales list is empty
	public void getSalesEmptyTest() {
		String name = "John";
		Salesperson salesperson = new Salesperson(name);
		assertTrue(salesperson.getSales().isEmpty());
	}
	
}
