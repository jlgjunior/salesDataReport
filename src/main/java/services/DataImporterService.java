package services;

import org.springframework.beans.factory.annotation.Autowired;

import builders.CustomerBuilder;
import builders.SalespersonBuilder;
import models.CSVCustomerData;
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
			PersistantModel model;
			CSVData csvData = csvReaderService.getNextCSVData();
			switch(csvData.getCode()) {
				case "001":
					CSVSalespersonData salespersonData = 
							(CSVSalespersonData) csvData;
					model = new SalespersonBuilder()
								.setCpf(salespersonData.getCpf())
								.setName(salespersonData.getName())			   
								.setSalary(salespersonData.getSalary())
								.build();
					break;
				case "002":
					CSVCustomerData customerData = 
							(CSVCustomerData) csvData;
					model = new CustomerBuilder()
								.setCnpj(customerData.getCnpj())
								.setName(customerData.getName())			   
								.setArea(customerData.getArea())
								.build();
					break;
				case "003":
					CSVCustomerData customerData = 
							(CSVCustomerData) csvData;
					model = new CustomerBuilder()
								.setCnpj(customerData.getCnpj())
								.setName(customerData.getName())			   
								.setArea(customerData.getArea())
								.build();
					break;
			}	
		}
	}
	
}
