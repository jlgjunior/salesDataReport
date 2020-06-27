package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.CSVCustomerData;
import models.CSVData;
import models.Customer;
import models.Person;
import org.junit.platform.commons.util.ReflectionUtils;
import org.springframework.test.util.ReflectionTestUtils;

public class CustomerTest {

	@Test
	public void getNameTest() {
		final String NAME = "Ed";
		Person customer = new Customer();
		ReflectionTestUtils.setField(customer, "name", NAME);
		assertEquals(NAME, customer.getName());
	}
	
	@Test
	public void loadDataTest() {
		final String NAME = "Ed";
		final String CNPJ = "10";
		final String AREA = "Games";
		boolean result;
		Customer customer = new Customer();
		CSVCustomerData csvData = new CSVCustomerData();
		ReflectionTestUtils.setField(csvData, "name", NAME);
		ReflectionTestUtils.setField(csvData, "cnpj", CNPJ);
		ReflectionTestUtils.setField(csvData, "area", AREA);
		customer.loadCSVData(csvData);
		result = csvData.getName().equals(customer.getName());
		result &= csvData.getCnpj().equals(customer.getCnpj());
		result &= csvData.getArea().equals(customer.getArea());
		assertTrue(result);
	}
	
}
