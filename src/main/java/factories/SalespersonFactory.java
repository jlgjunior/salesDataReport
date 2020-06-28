package factories;

import builders.SalespersonBuilder;
import models.CSVData;
import models.CSVSalespersonData;
import models.PersistantModel;

public class SalespersonFactory extends PersistantModelFactory {

	@Override
	public PersistantModel createPersistantModel(CSVData data) {
		CSVSalespersonData salespersonData = 
				(CSVSalespersonData) data;
		return new SalespersonBuilder()
					.setCpf(salespersonData.getCpf())
					.setName(salespersonData.getName())			   
					.setSalary(salespersonData.getSalary())
					.build();
	}

}
