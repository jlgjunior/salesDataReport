package utils;

import models.CSVData;
import models.CSVSaleData;

public class CSVDataFactory extends CSVDataAbstractFactory {

	private CSVPersonDataFactory csvPersonFactory;
	
	public CSVDataFactory() {

	}

	@Override
	public CSVData createCSVData(String[] data) {
		String type = data[0];
		CSVData csvReturnData = null;
		switch (type) {
			case "001":
			case "002":
				csvReturnData = csvPersonFactory.createCSVData(data);
				break;
			case "003":
				csvReturnData = new CSVSaleData();
				csvReturnData.loadData(data);
				break;
		}
		return null;
	}

}
