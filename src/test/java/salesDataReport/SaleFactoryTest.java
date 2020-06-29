package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factories.CSVDataFactory;
import factories.SaleFactory;
import models.Sale;
import services.CSVDataReaderService;
@SpringBootTest(classes= {CSVDataFactory.class, CSVDataReaderService.class})
@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class SaleFactoryTest {

	@Autowired
	CSVDataReaderService csvDataReaderService;

	@Test
	public void createPersistantModelTest() {
		final Float SALE_VALUE = 1199f;
		String filename;
		SaleFactory factory = new SaleFactory();
		filename = getClass().getClassLoader().getResource("exampleSale").getFile();
		csvDataReaderService.loadCSVFile(filename);
		Sale sale = factory.createPersistantModel(csvDataReaderService.getNextCSVData());
		assertEquals(SALE_VALUE, sale.getSaleValue());
	}
}
