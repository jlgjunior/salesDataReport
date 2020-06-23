package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import models.Person;
import models.Salesperson;
import models.Sale;

public class SalespersonTest {

	@Test
	//Checks if getName returns assigned name
	public void getNameTest() {
		String name = "John";
		Person person = new Salesperson(name);
		assertEquals(name, person.getName());
	}

	@Test
	//Checks if a sale was properly added to salesperson' sales list
	public void addSaleTest() {
		String name = "John";
		Integer id = 1;
		Salesperson salesperson = new Salesperson(name);
		Sale sale = new Sale(id);
		salesperson.addSale(sale);
		assertSame(salesperson.getSales().get(0), sale);
	}

	@Test
	//Checks if salesperson sales list is a list of sales
	public void getSalesTest() {
		String name = "John";
		Integer id = 1;
		Salesperson salesperson = new Salesperson(name);
		salesperson.getSales().add(new Sale(id));
		assertEquals(salesperson.getSales().get(0).getClass(), Sale.class);
	}
	
	@Test
	//Checks if new salesperson sales list is empty
	public void getSalesEmptyTest() {
		String name = "John";
		Salesperson salesperson = new Salesperson(name);
		assertTrue(salesperson.getSales().isEmpty());
	}
	
}
