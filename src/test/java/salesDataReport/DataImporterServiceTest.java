package salesDataReport;

import org.junit.Test;

import services.DataImporterService;

public class DataImporterServiceTest {

	@Test
	public void importFileTest() {
		String filename = getClass().getClassLoader().getResource("example").getFile();
		DataImporterService dataImporter = new DataImporterService();
		dataImporter.importDataFromFile(filename);
	}
	
}
