package salesDataReport;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.CSVData;
import models.CSVSalespersonData;

public class CSVSalespersonDataTest {

	@Test
	public void loadDataTest() {
		String[] data = {"001", "1234567891234", "Pedro", "50000"};
		CSVData salespersonData = new CSVSalespersonData();
		assertTrue(salespersonData.loadData(data));
	}
	
}
