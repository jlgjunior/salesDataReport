package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.CSVData;
import models.CSVSalespersonData;
import models.PersistantModel;
import models.Person;
import models.Salesperson;
import models.Sale;

public class SalespersonTest {

	@Test
	//Checks if getName returns assigned name
	public void getNameTest() {
		final String NAME = "John";
		Person person = new Salesperson();
		ReflectionTestUtils.setField(person, "name", NAME);
		assertEquals(NAME, person.getName());
	}

	@Test
	//Checks if a sale was properly added to salesperson' sales list
	public void addSaleTest() {
		final Integer ID = 1;
		Salesperson salesperson = new Salesperson();
		Sale sale = new Sale();
		ReflectionTestUtils.setField(sale, "id", ID);
		salesperson.addSale(sale);
		assertSame(salesperson.getSales().get(0), sale);
	}

	@Test
	//Checks if salesperson sales list is a list of sales
	public void getSalesTest() {
		final Integer ID = 1;
		Salesperson salesperson = new Salesperson();
		salesperson.getSales().add(new Sale());
		ReflectionTestUtils.setField(salesperson.getSales().get(0),
				                     "id", 
				                     ID);
		assertEquals(salesperson.getSales().get(0).getClass(), Sale.class);
	}
	
	@Test
	//Checks if new salesperson sales list is empty
	public void getSalesEmptyTest() {
		Salesperson salesperson = new Salesperson();
		assertTrue(salesperson.getSales().isEmpty());
	}
	
	@Test
	public void loadDataTest() {
		final String NAME = "Ed";
		final String CPF = "10";
		final Float SALARY = 1000f;
		boolean result;
		PersistantModel model = new Salesperson();
		CSVSalespersonData csvData = new CSVSalespersonData();
		ReflectionTestUtils.setField(csvData, "name", NAME);
		ReflectionTestUtils.setField(csvData, "cpf", CPF);
		ReflectionTestUtils.setField(csvData, "salary", SALARY);
		CSVData gen = (CSVData) csvData;
		model.loadCSVData(gen);
		Salesperson salesperson = (Salesperson) model;
		result = csvData.getName().equals(salesperson.getName());
		result &= csvData.getCpf().equals(salesperson.getCpf());
		result &= csvData.getSalary().equals(salesperson.getSalary());
		assertTrue(result);
	}
	
}
