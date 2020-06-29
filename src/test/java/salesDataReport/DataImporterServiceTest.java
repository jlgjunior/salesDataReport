package salesDataReport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factories.CSVDataFactory;
import repositories.CustomerRepository;
import repositories.SaleRepository;
import repositories.SalespersonRepository;
import services.CSVDataReaderService;
import services.DataImporterService;

@SpringBootTest(classes= {DataImporterService.class, 
						  CSVDataReaderService.class, 
						  CSVDataFactory.class,
						  SalespersonRepository.class,
						  SaleRepository.class,
						  CustomerRepository.class})
@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class DataImporterServiceTest {

	@Autowired
	private DataImporterService dataImporter;
	
	@Test
	public void importFileTest() {
		String filename = getClass().getClassLoader().getResource("example").getFile();
		dataImporter.importDataFromFile(filename);
	}
	
}
