package salesDataReport;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import org.junit.Test;

import models.CSVData;
import models.CSVSalespersonData;
import services.CSVDataReaderService;

public class CSVDataReaderServiceTest {
	
	@Test
	public void loadCSVFileTest() {
		String filename;
		filename = getClass().getClassLoader().getResource("example").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		assertTrue(csvDataReaderService.loadCSVFile(filename));
	}
	
	@Test
	public void getNextCSVDataTest() {
		String filename;
		String[] data = {"001", "1234567891234", "Pedro", "50000"};
		CSVData resultData = null;
		CSVData salespersonData = new CSVSalespersonData();
		salespersonData.loadData(data);
		filename = getClass().getClassLoader().getResource("example").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		if (csvDataReaderService.loadCSVFile(filename)) {
			resultData = csvDataReaderService.getNextCSVData();
			assertEquals(salespersonData, resultData);
		} else {
			fail("Could not load CSV file");
		}
	}
	
	@Test
	public void hasNextLineTest() {
		String filename;
		Reader reader;
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		if (csvDataReaderService.hasNextLine()) {
			fail("Should not have a next line");
		}
		filename = getClass().getClassLoader().getResource("example").getFile();
		if (csvDataReaderService.loadCSVFile(filename)) {
			assertTrue(csvDataReaderService.hasNextLine());
		} else {
			fail("Could not load CSV file");
		}
	}
	
	@Test
	public void getNextLineTest() {
		String filename;
		Reader reader;
		final String EXAMPLE = "example";
		final String EXAMPLE_SIMPLE = "exampleSimple";
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		Integer count = 0;
		Integer expected = 7;
		while (csvDataReaderService.hasNextLine()) {
			csvDataReaderService.getNextLine();	
			++count;
		}
		filename = getClass().getClassLoader().getResource(EXAMPLE).getFile();
		if (csvDataReaderService.loadCSVFile(filename)) {
			while (csvDataReaderService.hasNextLine()) {
				csvDataReaderService.getNextLine();	
				++count;
			}
		} else {
			fail("Could not load CSV file");
		}
		filename = getClass().getClassLoader().getResource(EXAMPLE_SIMPLE).getFile();
		csvDataReaderService.setSeparator('!');
		if (csvDataReaderService.loadCSVFile(filename)) {
			while (csvDataReaderService.hasNextLine()) {
				csvDataReaderService.getNextLine();	
				++count;
			}
		} else {
			fail("Could not load CSV file");
		}
		assertEquals(expected, count);
	}
	
	@Test
	public void getLoadedDataTest() {
		String result = "";
		String expected = "testteste";
		List<String[]> resultList = null;
		String filename = getClass().getClassLoader().getResource("exampleSimple").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		csvDataReaderService.setSeparator('!');
		if (csvDataReaderService.loadCSVFile(filename)) {
			resultList = csvDataReaderService.getLoadedData();
			
			for (String[] line : resultList) {
				for (String field : line) {
					result += field;
				}
			}
			
		}
		else {
			fail("Could not load CSV file");
		}
		assertEquals(result, expected);
	}

}
