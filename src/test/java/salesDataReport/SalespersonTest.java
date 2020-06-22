package salesDataReport;

import org.junit.Test;

public class SalespersonTest {

	@Test
	public void getNameTest() {
		Person person = new Person("John");
		assertEquals("John", person.getName());
	}
}
