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
		CSVParser csvParser = new CSVParserBuilder().withSeparator(this.separator)
				                          			.withIgnoreQuotations(true)
				                          			.build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0)
														  .withCSVParser(csvParser)
														  .build();
		
		try {
			return csvReader.readAll();
		} catch (IOException | CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LinkedList<String[]>();
	}

	public void setSeparator(char separator) {
		this.separator = separator;
	}

}
