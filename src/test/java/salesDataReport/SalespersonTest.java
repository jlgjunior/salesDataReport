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
	//Checks if new salesperson sales list is empty
	public void getSaleEmptysTest() {
		String name = "John";
		Person salesperson = new Salesperson(name);
		assertTrue(salesperson.getSales().isEmpty());
	}
	
}
