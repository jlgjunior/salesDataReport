package salesDataReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import models.CSVCustomerData;
import models.CSVSaleData;
import models.CSVSalespersonData;
import services.CSVDataReaderService;

public class CSVDataFactoryTest {
	
	@Test
	public void createCSVDataTest() {
		String filename = getClass().getClassLoader().getResource("example").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		if (csvDataReaderService.loadCSVFile(filename)) {
			assertTrue(csvDataReaderService.getNextCSVData() instanceof CSVSalespersonData);
			assertTrue(csvDataReaderService.getNextCSVData() instanceof CSVSalespersonData);
			assertTrue(csvDataReaderService.getNextCSVData() instanceof CSVCustomerData);
			assertTrue(csvDataReaderService.getNextCSVData() instanceof CSVCustomerData);
			assertTrue(csvDataReaderService.getNextCSVData() instanceof CSVSaleData);
			assertTrue(csvDataReaderService.getNextCSVData() instanceof CSVSaleData);
		}
		else {
			fail("Could not load csv file");
		}
	}
	
}
