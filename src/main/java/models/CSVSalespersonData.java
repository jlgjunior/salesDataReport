package models;

public class CSVSalespersonData extends CSVData {

	private String cpf;
	private String name;
	private float salary;
	
	public CSVSalespersonData() {

	}
	
	public CSVSalespersonData(String cpf, String name, float salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
			
	}
	
	public void loadData(String[] data) {
		String cpf = data[1];
		String name = data[2];
		float salary = Float.valueOf(data[3]);
	}

}
