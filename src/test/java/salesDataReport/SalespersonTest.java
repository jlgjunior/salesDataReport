package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Person;
import models.Salesperson;

public class SalespersonTest {

	@Test
	public void getNameTest() {
		String name = "John";
		Person person = new Salesperson(name);
		assertEquals(name, person.getName());
	}
}
