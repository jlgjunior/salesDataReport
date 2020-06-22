package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Customer;
import models.Person;


public class CustomerTest {

	@Test
	public void getNameTest() {
		String name = "Ed";
		Person person = new Customer(name);
		assertEquals(name, person.getName());
	}
	
}
