package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Person;
import models.Salesperson;

public class SalespersonTest {

	@Test
	public void getNameTest() {
		Person person = new Salesperson("John");
		assertEquals("John", person.getName());
	}
}
