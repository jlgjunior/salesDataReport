package services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import builders.ReportBuilder;
import models.Customer;
import models.Report;
import models.Sale;
import models.Salesperson;
import repositories.IRepository;

@Service
public class ReportService {

	private Path outputFolder;
	@Autowired
	FileSystemManagerService fileSystemManagerService;
	@Autowired
	private DataImporterService dataImporterService;
	@Autowired
	CSVDataReaderService csvReaderService;
	@Autowired
	IRepository<Salesperson> salespersonRepository;
	@Autowired
	IRepository<Customer> customerRepository;
	@Autowired
	IRepository<Sale> saleRepository;
	@Autowired
	IRepository<Report> reportRepository;
	
	public ReportService() {
		
	}
	
	public void generateReport(String filepath) {
		dataImporterService.importDataFromFile(filepath);
		SortedSet<Salesperson> salespeople =
								salespersonRepository.findAll();
		
		Integer salespeopleCount = salespeople.size();
		Integer customersCount = customerRepository
											.findAll().size();
		
		SortedSet<Sale> sales = saleRepository.findAll();
		Long mostExpensiveSaleId = 
				sales.size() > 0? sales.first().getId() : null;

		String worstSalespersonName = 
				salespeople.size() > 0? salespeople.first().getName() : null;
	
		Report report = new ReportBuilder()
							.setCustomersCount(customersCount)
							.setSalespeopleCount(salespeopleCount)
							.setMostExpensiveSaleId(mostExpensiveSaleId)
							.setWorstSalespersonName(worstSalespersonName)
							.build();
		reportRepository.save(report);
	}										
}
