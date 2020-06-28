package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import factories.PersistantModelFactory;
import models.CSVData;
import models.Customer;
import models.PersistantModel;
import models.Sale;
import models.Salesperson;
import repositories.CustomerRepository;
import repositories.SaleRepository;
import repositories.SalespersonRepository;

@Service
public class DataImporterService {

	@Autowired
	CSVDataReaderService csvReaderService;
	@Autowired
	SalespersonRepository salespersonRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	SaleRepository saleRepository;
	
	public DataImporterService() {
		
	}

	public void importDataFromFile(String filepath) {
		csvReaderService.loadCSVFile(filepath);
		while(csvReaderService.hasNextData()) {
			CSVData csvData = csvReaderService.getNextCSVData();
			importData(csvData);
		}
	}
	
	private void importData(CSVData csvData) {
		switch(csvData.getCode()) {
			case "001":
				PersistantModelFactory<Salesperson> salespersonFactory;
				salespersonFactory = PersistantModelFactory
						         .getConcreteFactory(csvData);
				Salesperson salesperson = 
						salespersonFactory.createPersistantModel(csvData);
				salespersonRepository.save(salesperson);
				break;
			case "002":
				PersistantModelFactory<Customer> customerFactory;
				customerFactory = PersistantModelFactory
						         .getConcreteFactory(csvData);
				Customer customer = 
						customerFactory.createPersistantModel(csvData);
				customerRepository.save(customer);
				break;
			case "003":
				PersistantModelFactory<Sale> saleFactory;
				saleFactory = PersistantModelFactory
						         .getConcreteFactory(csvData);
				Sale sale = 
						saleFactory.createPersistantModel(csvData);
				saleRepository.save(sale);
				break;
		}
	}
	
}
