package factories;

import builders.SalespersonBuilder;
import models.CSVData;
import models.CSVSalespersonData;
import models.Salesperson;

public class SalespersonFactory extends PersistantModelFactory<Salesperson> {

	@Override
	public Salesperson createPersistantModel(CSVData data) {
		CSVSalespersonData salespersonData = 
				(CSVSalespersonData) data;
		return new SalespersonBuilder()
					.setCpf(salespersonData.getCpf())
					.setName(salespersonData.getName())			   
					.setSalary(salespersonData.getSalary())
					.build();
	}

}
