package salesDataReport;

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

}
