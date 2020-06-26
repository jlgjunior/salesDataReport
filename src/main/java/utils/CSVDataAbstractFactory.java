package utils;

import org.springframework.stereotype.Component;

import models.CSVData;

@Component
public abstract class CSVDataAbstractFactory {

	protected CSVDataAbstractFactory() {
		
	}
	
	public abstract CSVData createCSVData(String[] data);
}
