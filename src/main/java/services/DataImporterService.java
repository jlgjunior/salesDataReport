package services;

import org.springframework.beans.factory.annotation.Autowired;

public class DataImporterService {

	@Autowired
	CSVDataReaderService csvReaderService;
	
	public DataImporterService() {
		
	}
	
}
