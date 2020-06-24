package salesDataReport;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import org.junit.Test;

import services.CSVDataReaderService;

public class CSVDataReaderServiceTest {
	
	@Test
	public void loadDataTest() {
		String result = "";
		String expected = "testteste";
		List<String[]> resultList = null;
		String filename = getClass().getClassLoader().getResource("exampleSimple").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		csvDataReaderService.setSeparator('!');
		try {
			Reader reader = new FileReader(filename);
			resultList = csvDataReaderService.loadData(reader);
		
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
