package salesDataReport;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factories.CSVDataFactory;
import models.CSVData;
import models.CSVSalespersonData;
import services.CSVDataReaderService;

@SpringBootTest(classes= {CSVDataFactory.class, CSVDataReaderService.class})
@RunWith(SpringRunner.class)
@SpringBootConfiguration
public class CSVDataReaderServiceTest {
	@Autowired
	CSVDataReaderService csvDataReaderService;
	
	@Test
	public void unloadTest() {
		String filename;
		filename = getClass().getClassLoader().getResource("example").getFile();
		csvDataReaderService.setSeparator('ç');
		csvDataReaderService.loadCSVFile(filename);
		csvDataReaderService.unload();
		assertNull(csvDataReaderService.getNextCSVData());
	}
	
	@Test
	public void loadCSVFileTest() {
		String filename;
		filename = getClass().getClassLoader().getResource("example").getFile();
		csvDataReaderService.setSeparator('ç');
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
		csvDataReaderService.setSeparator('ç');
		if (csvDataReaderService.loadCSVFile(filename)) {
			resultData = csvDataReaderService.getNextCSVData();
			assertEquals(salespersonData, resultData);
		} else {
			fail("Could not load CSV file");
		}
	}
	
	@Test
	public void hasNextLineTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final Object[] ARGS = {};
		final Class<?>[] TYPES = {};
		String filename;
		Method hasNextLine = CSVDataReaderService.class.getDeclaredMethod("hasNextLine", TYPES);
		hasNextLine.setAccessible(true);
		csvDataReaderService.unload();
		if (((boolean)hasNextLine.invoke(csvDataReaderService, ARGS))) {
			fail("Should not have a next line");
		}
		filename = getClass().getClassLoader().getResource("example").getFile();
		csvDataReaderService.setSeparator('ç');
		if (csvDataReaderService.loadCSVFile(filename)) {
			assertTrue(((boolean)hasNextLine.invoke(csvDataReaderService, ARGS)));
		} else {
			fail("Could not load CSV file");
		}
	}
	
	@Test
	public void getNextLineTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		final String EXAMPLE = "example";
		final String EXAMPLE_SIMPLE = "exampleSimple";
		final Object[] ARGS = {};
		final Class<?>[] TYPES = {};
		Method getNextLine = CSVDataReaderService.class.getDeclaredMethod("getNextLine", TYPES);
		getNextLine.setAccessible(true);
		String filename;
		Integer count = 0;
		Integer expected = 7;
		csvDataReaderService.unload();
		while (((String[])getNextLine.invoke(csvDataReaderService, ARGS)).length != 0) {
			++count;
		}
		filename = getClass().getClassLoader().getResource(EXAMPLE).getFile();
		if (csvDataReaderService.loadCSVFile(filename)) {
			while (((String[])getNextLine.invoke(csvDataReaderService, ARGS)).length != 0) {
				++count;
			}
		} else {
			fail("Could not load CSV file");
		}
		filename = getClass().getClassLoader().getResource(EXAMPLE_SIMPLE).getFile();
		csvDataReaderService.setSeparator('!');
		if (csvDataReaderService.loadCSVFile(filename)) {
			while (((String[])getNextLine.invoke(csvDataReaderService, ARGS)).length != 0) {
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
