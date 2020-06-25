package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.junit.Test;

import models.CSVData;
import models.CSVSalespersonData;
import services.CSVDataReaderService;


public class CSVSalespersonDataTest {

	@Test
	public void getNameTest() {
		String filename;
		Reader reader;
		CSVSalespersonData resultData = null;
		CSVSalespersonData salespersonData = new CSVSalespersonData();
	    salespersonData 
		     .loadData("1234567891234", "Pedro", "50000");
		filename = getClass().getClassLoader().getResource("example").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		try {
			reader = new FileReader(filename);
			csvDataReaderService.loadData(reader);
			resultData = (CSVSalespersonData) csvDataReaderService.getNextCSVData();
			assertEquals(salespersonData, resultData);
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		}
	}
	
}
