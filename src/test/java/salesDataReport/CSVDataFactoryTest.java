package salesDataReport;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import factories.CSVDataFactory;
import models.CSVCustomerData;
import models.CSVSaleData;
import models.CSVSalespersonData;
import services.CSVDataReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes= {CSVDataFactory.class, CSVDataReaderService.class})
@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class CSVDataFactoryTest {
	@Autowired
	CSVDataReaderService csvDataReaderService;
	
	@Test
	public void createCSVDataTest() {
		String filename = getClass().getClassLoader().getResource("example").getFile();
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
