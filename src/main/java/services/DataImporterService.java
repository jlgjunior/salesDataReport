package services;

import org.springframework.beans.factory.annotation.Autowired;

import builders.SalespersonBuilder;
import models.CSVData;
import models.CSVSalespersonData;
import models.PersistantModel;

public class DataImporterService {

	@Autowired
	CSVDataReaderService csvReaderService;
	
	public DataImporterService() {
		
	}

	public void importDataFromFile(String filepath) {
		csvReaderService.loadCSVFile(filepath);
		while(csvReaderService.hasNextData()) {
			CSVData csvData = csvReaderService.getNextCSVData();
			switch(csvData.getCode()) {
				case "001":
					CSVSalespersonData salespersonData = 
							(CSVSalespersonData) csvData;
					PersistantModel model = new SalespersonBuilder()
											.setCpf(salespersonData.getCpf())
											.setName(salespersonData.getName())			   
											.setSalary(salespersonData.getSalary())
											.build();
					break;
			}	
		}
	}
	
}
