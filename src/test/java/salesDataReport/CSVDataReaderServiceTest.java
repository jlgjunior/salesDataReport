package salesDataReport;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
	public void hasNextLineTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String filename;
		Object[] args = {};
		Class<?>[] types = {};
		Method hasNextLine = CSVDataReaderService.class.getDeclaredMethod("hasNextLine", types);
		hasNextLine.setAccessible(true);
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		if (((boolean)hasNextLine.invoke(csvDataReaderService, args))) {
			fail("Should not have a next line");
		}
		filename = getClass().getClassLoader().getResource("example").getFile();
		if (csvDataReaderService.loadCSVFile(filename)) {
			assertTrue(((boolean)hasNextLine.invoke(csvDataReaderService, args)));
		} else {
			fail("Could not load CSV file");
		}
	}
	
	@Test
	public void getNextLineTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		final String EXAMPLE = "example";
		final String EXAMPLE_SIMPLE = "exampleSimple";
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		String filename;
		Integer count = 0;
		Integer expected = 7;
		while (csvDataReaderService.getNextLine().length != 0) {
			++count;
		}
		filename = getClass().getClassLoader().getResource(EXAMPLE).getFile();
		if (csvDataReaderService.loadCSVFile(filename)) {
			while (csvDataReaderService.getNextLine().length != 0) {
				++count;
			}
		} else {
			fail("Could not load CSV file");
		}
		filename = getClass().getClassLoader().getResource(EXAMPLE_SIMPLE).getFile();
		csvDataReaderService.setSeparator('!');
		if (csvDataReaderService.loadCSVFile(filename)) {
			while (csvDataReaderService.getNextLine().length != 0) {
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
