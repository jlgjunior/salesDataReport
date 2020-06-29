package factories;

import models.CSVData;

public abstract class PersistantModelFactory <T> {
	
	public static PersistantModelFactory getConcreteFactory(CSVData data) {
		switch(data.getCode()) {
			case "001":
				return new SalespersonFactory();
			case "002":
				return new CustomerFactory();
			case "003":
				return new SaleFactory();
		}
		return null;
	}
	
	public abstract T createPersistantModel(CSVData data);

}
