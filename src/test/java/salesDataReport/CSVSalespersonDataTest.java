package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.CSVData;
import models.CSVSalespersonData;

public class CSVSalespersonDataTest {

	@Test
	public void loadDataTest() {
		String[] data = {"001", "1234567891234", "Pedro", "50000"};
		CSVData salespersonData = new CSVSalespersonData();
		assertTrue(salespersonData.loadData(data));
	}
	
	@Test
	public void getCpfTest() {
		final String CPF = "1234567891234";
		String[] data = {"001", CPF, "Pedro", "50000"};
		CSVSalespersonData salespersonData = new CSVSalespersonData();
		salespersonData.loadData(data);
		assertEquals(CPF, salespersonData.getCpf());
	}
	
	@Test
	public void getNameTest() {
		final String NAME = "Pedro";
		String[] data = {"001", "1234567891234", NAME, "50000"};
		CSVSalespersonData salespersonData = new CSVSalespersonData();
		salespersonData.loadData(data);
		assertEquals(NAME, salespersonData.getName());
	}
	
	@Test
	public void getSalaryTest() {
		final Float SALARY = 50000f;
		String[] data = {"001", "1234567891234", "Pedro", "50000"};
		CSVSalespersonData salespersonData = new CSVSalespersonData();
		salespersonData.loadData(data);
		assertEquals(SALARY, salespersonData.getSalary());
	}
	
}
