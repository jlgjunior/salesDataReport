package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Customer;
import models.Person;
import org.springframework.test.util.ReflectionTestUtils;

public class CustomerTest {

	@Test
	public void getNameTest() {
		final String NAME = "Ed";
		Person<Customer> customer = new Customer();
		ReflectionTestUtils.setField(customer, "name", NAME);
		assertEquals(NAME, customer.getName());
	}
}
