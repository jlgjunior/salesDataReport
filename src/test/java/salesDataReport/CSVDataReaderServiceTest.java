package salesDataReport;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.Reader;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import services.CSVDataReaderService;


public class CSVDataReaderServiceTest {

	@Autowired
	CSVDataReaderService csvDataReaderService;
	
	@Test
	public void initTest() {
		try {
			new CSVDataReaderService();
		}
		catch (Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test
	public void loadDataTest() {
		try {
			Reader reader = new FileReader("example.txt");
			this.csvDataReaderService.loadData(reader);
		}
		catch (Exception e){
			fail(e.getMessage());
		}
	}

}
