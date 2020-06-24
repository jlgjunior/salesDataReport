package services;

import java.io.Reader;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVDataReaderService {

	
	public CSVDataReaderService() {
	 
	}

	public List<String[]> loadData(Reader reader) {
		CSVParser csvParser = new CSVParserBuilder().withSeparator('ç')
				                          			.withIgnoreQuotations(true)
				                          			.build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0)
														  .withCSVParser(csvParser)
														  .build();
		
		return csvReader.readAll();
	}

}
