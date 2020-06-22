package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Person;

public class SalespersonTest {

	@Test
	public void getNameTest() {
		Person person = new Person("John");
		assertEquals("John", person.getName());
	}
}
