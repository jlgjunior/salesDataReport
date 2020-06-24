package salesDataReport;

import static org.junit.Assert.*;

import org.junit.Test;

import services.CSVDataReaderService;

public class CSVDataReaderServiceTest {

	@Test
	public void init() {
		try {
			new CSVDataReaderService();
		}
		catch (Exception e){
			fail("Not yet implemented");
		}
		
	}

}
