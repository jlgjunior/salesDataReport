package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.CSVCustomerData;
import models.CSVData;

public class CSVCustomerDataTest {

	@Test
	public void loadDataTest() {
		String[] data = {"002", "2345675434544345", "Jose da Silva", "Rural"};
		CSVData customerData = new CSVCustomerData();
		assertTrue(customerData.loadData(data));
	}

	@Test
	public void getCnpjTest() {
		final String CNPJ = "2345675434544345";
		String[] data = {"002", CNPJ, "Jose da Silva", "Rural"};
		CSVData customerData = new CSVCustomerData();
		String resultCnpj;
		customerData.loadData(data);
		resultCnpj = ((CSVCustomerData) customerData).getCnpj();
		assertEquals(CNPJ, resultCnpj);
	}
	
	@Test
	public void getNameTest() {
		final String NAME = "Jose da Silva";
		String[] data = {"002", "2345675434544345", NAME, "Rural"};
		CSVCustomerData customerData = new CSVCustomerData();
		customerData.loadData(data);
		assertEquals(NAME, customerData.getName());
	}
	
	@Test
	public void getAreaTest() {
		final String AREA = "Rural";
		final String NAME = "Jose da Silva";
		String[] data = {"002", "2345675434544345", NAME, AREA};
		CSVCustomerData customerData = new CSVCustomerData();
		customerData.loadData(data);
		assertEquals(AREA, customerData.getArea());
	}
}
