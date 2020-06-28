package models;

public abstract class CSVData {
	
	private String code;
	
	public abstract boolean loadData(String[] data);

	public String getCode() {
		return code;
	}	
}
