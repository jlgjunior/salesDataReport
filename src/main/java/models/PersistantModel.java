package models;

public interface PersistantModel <T extends CSVData>{
	
	public void loadCSVData(T data);
}
