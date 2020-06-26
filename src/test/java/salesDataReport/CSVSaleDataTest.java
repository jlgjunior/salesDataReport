package salesDataReport;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.CSVData;
import models.CSVSaleData;

public class CSVSaleDataTest {

	@Test
	public void loadDataTest() {
		String[] data = {"003", "10", 
				         "[1-10-100,2-30-2.50,3-40-3.10]", "Pedro"};
		CSVData salespersonData = new CSVSaleData();
		assertTrue(salespersonData.loadData(data));
	}
	
}
