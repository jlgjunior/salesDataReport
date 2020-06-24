package services;

import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

@Service
@Qualifier("csvDataReaderService")
public class CSVDataReaderService {

	private char separator = 'ç';
	
	@Autowired
	public CSVDataReaderService() {
	 
	}

	public List<String[]> loadData(Reader reader) {
		List<String[]> resultList;
		CSVParser csvParser = new CSVParserBuilder().withSeparator(this.separator)
				                          			.withIgnoreQuotations(true)
				                          			.build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0)
														  .withCSVParser(csvParser)
														  .build();
		
		try {
			resultList =  csvReader.readAll();
		} catch (IOException | CsvException e) {
			resultList = new LinkedList<String[]>();
			e.printStackTrace();
		}
		return resultList;
	}

	public void setSeparator(char separator) {
		this.separator = separator;
	}

}
