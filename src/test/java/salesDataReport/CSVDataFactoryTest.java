package salesDataReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import models.CSVSalespersonData;
import services.CSVDataReaderService;

public class CSVDataFactoryTest {
	
	@Test
	public void createCSVDataTest() {
		String filename = getClass().getClassLoader().getResource("example").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		if (csvDataReaderService.loadCSVFile(filename)) {
			assertTrue(csvDataReaderService.getNextCSVData() instanceof CSVSalespersonData);
		}
		else {
			fail("Could not load csv file");
		}
	}
	
}
