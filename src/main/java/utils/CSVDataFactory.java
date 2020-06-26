package utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import models.CSVCustomerData;
import models.CSVData;
import models.CSVSaleData;
import models.CSVSalespersonData;

@Component
public class CSVDataFactory extends CSVDataAbstractFactory {

	public CSVDataFactory() {

	}

	@Override
	public CSVData createCSVData(String[] data) {
		String type;
		CSVData csvReturnData = null;
		try {
			type = data[0];
			switch (type) {
				case "001":
					csvReturnData = new CSVSalespersonData();
					break;
				case "002":
					csvReturnData = new CSVCustomerData();
					break;
				case "003":
					csvReturnData = new CSVSaleData();
					break;
			}
			csvReturnData.loadData(data);
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			return null;
		}
		return csvReturnData;
	}

}
