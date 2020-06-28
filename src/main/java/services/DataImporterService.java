package services;

import org.springframework.beans.factory.annotation.Autowired;

import factories.PersistantModelFactory;
import models.CSVData;
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
			model = PersistantModelFactory
					.getConcreteFactory(csvData)
					.createPersistantModel(csvData);
		}
	}
	
}
