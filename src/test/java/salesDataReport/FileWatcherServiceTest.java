package salesDataReport;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factories.CSVDataFactory;
import repositories.CustomerRepository;
import repositories.ReportRepository;
import repositories.SaleRepository;
import repositories.SalespersonRepository;
import services.CSVDataReaderService;
import services.DataImporterService;
import services.FileSystemManagerService;
import services.FileWatcherService;
import services.ReportService;

@SpringBootTest(classes= {DataImporterService.class, 
		  CSVDataReaderService.class, 
		  ReportService.class,
		  FileSystemManagerService.class,
		  FileWatcherService.class,
		  CSVDataFactory.class,
		  ReportRepository.class,
		  SalespersonRepository.class,
		  SaleRepository.class,
		  CustomerRepository.class})
@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class FileWatcherServiceTest {

	@Autowired
	FileWatcherService fileWatcherService;
	
	@Test
	public void testWatch() throws IOException {
		fileWatcherService.watch();
	}
}
