package services;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
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

		Salesperson salesperson = getWorstSalesperson();	
		String worstSalespersonName =
		               salesperson != null? salesperson.getName() : null;
	
		Report report = new ReportBuilder()
							.setCustomersCount(customersCount)
							.setSalespeopleCount(salespeopleCount)
							.setMostExpensiveSaleId(mostExpensiveSaleId)
							.setWorstSalespersonName(worstSalespersonName)
							.build();
		String fileName = Paths.get(filepath).getFileName().toString();
		reportRepository.saveToFile(report, fileName);
		reset();
	}

	//It could be more efficient if Sales were to be linked with
	//salesperson during CSV data reading, but in the specification
	//there was no guarantee the data would be ordered
	private Salesperson getWorstSalesperson() {
		Salesperson worstSalesperson = null;
		Map<String, Salesperson> salespeople = new HashMap<String, Salesperson>();
		SortedSet<Salesperson> salespeopleData = salespersonRepository.findAll();
		for (Salesperson salesperson : salespeopleData) {
			salespeople.put(salesperson.getName(), salesperson);
		}
		for (Sale sale : saleRepository.findAll()) {
			Salesperson salesperson = 
					salespeople.get(sale.getSalespersonName());
			if (salesperson != null) {
				salesperson.addSale(sale);
			}
		}
		for (Salesperson salesperson : salespeopleData) {
			if (salesperson.worseSellerThan(worstSalesperson)) {
				worstSalesperson = salesperson;
			}
		}
		return worstSalesperson;
	}

	private void reset() {
		saleRepository.reset();
		salespersonRepository.reset();
		customerRepository.reset();
		reportRepository.reset();
	}										
}
