package services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import models.CSVData;
import utils.CSVDataFactory;

@Service
public class CSVDataReaderService {

	@Autowired
	private CSVDataFactory csvDataFactory;
	private char separator;
	private List<String[]> loadedData;

	public CSVDataReaderService() {
	  init();
	}
	
	public void init() {
		separator = 'ç';
		loadedData = new LinkedList<String[]>();	
	}
	
	public boolean loadData(Reader reader) {
		CSVParser csvParser = new CSVParserBuilder().withSeparator(this.separator)
				                          			.withIgnoreQuotations(true)
				                          			.build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(0)
														  .withCSVParser(csvParser)
														  .build();	
		try {
			this.loadedData =  csvReader.readAll();
			return true;
		} catch (IOException | CsvException e) {
			return false;
		}
	}

	public void setSeparator(char separator) {
		this.separator = separator;
	}

	public List<String[]> getLoadedData() {
		return this.loadedData;
	}
	
	public boolean hasNextData() {
		return hasNextLine();
	}
	
	private boolean hasNextLine() {
		return !this.loadedData.isEmpty();
	}
	
	private String[] getNextLine() {
		String [] resultArray = {}; 
		resultArray = (hasNextLine() ? this.loadedData.remove(0) : resultArray);
		return resultArray;
	}
	
	public CSVData getNextCSVData() {
		String[] data;
		CSVData csvDataResult = null;
		if (hasNextLine()){
			data = getNextLine();
			csvDataResult = csvDataFactory.createCSVData(data);
		}
		return csvDataResult;
	}

	public boolean loadCSVFile(String filepath) {
		Reader reader;
		try {
			reader = new FileReader(filepath);
			return loadData(reader);
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	public void unload() {
		init();
	}

}
