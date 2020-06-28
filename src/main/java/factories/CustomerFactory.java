package factories;

import builders.CustomerBuilder;
import models.CSVCustomerData;
import models.CSVData;
import models.PersistantModel;

public class CustomerFactory extends PersistantModelFactory {

	@Override
	public PersistantModel createPersistantModel(CSVData data) {
		CSVCustomerData customerData = 
				(CSVCustomerData) data;
		return new CustomerBuilder()
					.setCnpj(customerData.getCnpj())
					.setName(customerData.getName())			   
					.setArea(customerData.getArea())
					.build();
	}

}
