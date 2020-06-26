package utils;

import models.CSVCustomerData;
import models.CSVData;
import models.CSVSalespersonData;

public class CSVPersonDataFactory extends CSVDataAbstractFactory {

	@Override
	public CSVData createCSVData(String[] data) {
		String type = data[0];
		CSVData returnData = null;
		switch (type) {
			case "001":
				returnData = new CSVSalespersonData();
				returnData.loadData(data);
				break;
			case "002":
				returnData = new CSVCustomerData();
				returnData.loadData(data);
				break;
		}
		return returnData;
	}

}
