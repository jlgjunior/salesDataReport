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
	public void getNextCSVDataTest() {
		String filename;
		Reader reader;
		String[] data = {"001", "1234567891234", "Pedro", "50000"};
		CSVData resultData = null;
		CSVData salespersonData = new CSVSalespersonData();
		salespersonData.loadData(data);
		filename = getClass().getClassLoader().getResource("example").getFile();
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		try {
			reader = new FileReader(filename);
			csvDataReaderService.loadData(reader);
			resultData = csvDataReaderService.getNextCSVData();
			assertEquals(salespersonData, resultData);
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
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
		try {
			reader = new FileReader(filename);
			csvDataReaderService.loadData(reader);
			assertTrue(csvDataReaderService.hasNextLine());
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void getNextLineTest() {
		String filename;
		Reader reader;
		CSVDataReaderService csvDataReaderService = new CSVDataReaderService();
		Integer count = 0;
		Integer expected = 7;
		while (csvDataReaderService.hasNextLine()) {
			csvDataReaderService.getNextLine();	
			++count;
		}
		filename = getClass().getClassLoader().getResource("example").getFile();
		try {
			reader = new FileReader(filename);
			csvDataReaderService.loadData(reader);
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		}
		while (csvDataReaderService.hasNextLine()) {
			csvDataReaderService.getNextLine();	
			++count;
		}
		filename = getClass().getClassLoader().getResource("exampleSimple").getFile();
		try {
			reader = new FileReader(filename);
			csvDataReaderService.setSeparator('!');
			csvDataReaderService.loadData(reader);
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		}
		while (csvDataReaderService.hasNextLine()) {
			csvDataReaderService.getNextLine();	
			++count;
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
