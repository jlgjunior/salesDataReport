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
	
	public void loadData(String cpf, String name, String salary) {
		this.cpf = cpf;
		this.name = name;
		this.salary = Float.valueOf(salary);
	}

}
