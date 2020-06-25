package salesDataReport;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import org.junit.Test;

import services.CSVDataReaderService;

public class CSVDataReaderServiceTest {
	
	@Test
	public void getNextLineTest() {
		String filename;
		Reader reader;
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		Integer count = 0;
		while (csvDataReaderService.hasNextLine()) {
			csvDataReaderService.getNextLine();	
			++count;
		}
		filename = getClass().getClassLoader().getResource("example").getFile();
		reader = new FileReader(filename);
		csvDataReaderService.loadData(reader);
		while (csvDataReaderService.hasNextLine()) {
			csvDataReaderService.getNextLine();	
			++count;
		}
		filename = getClass().getClassLoader().getResource("exampleSimple").getFile();
		reader = new FileReader(filename);
		csvDataReaderService.setSeparator('!');
		csvDataReaderService.loadData(reader);
		while (csvDataReaderService.hasNextLine()) {
			csvDataReaderService.getNextLine();	
			++count;
		}
		
	}
	
	@Test
	public void getLoadedDataTest() {
		String result = "";
		String expected = "testteste";
		List<String[]> resultList = null;
		String filename = getClass().getClassLoader().getResource("exampleSimple").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		csvDataReaderService.setSeparator('!');
		try {
			Reader reader = new FileReader(filename);
			csvDataReaderService.loadData(reader);
			resultList = csvDataReaderService.getLoadedData();
		
			for (String[] line : resultList) {
				for (String field : line) {
					result += field;
				}
			}
		}
		catch (Exception e){   
			fail(e.getMessage());
		}
		assertEquals(result, expected);
	}

}
