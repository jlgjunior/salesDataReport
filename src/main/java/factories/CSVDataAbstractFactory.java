package factories;

import models.CSVData;

public abstract class CSVDataAbstractFactory {

	protected CSVDataAbstractFactory() {
		
	}
	
	public abstract CSVData createCSVData(String[] data);
}
