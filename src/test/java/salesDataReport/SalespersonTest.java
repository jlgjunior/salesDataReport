package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.Person;
import models.Product;
import models.Salesperson;
import models.Sale;

public class SalespersonTest {

	@Test
	//Checks if getName returns assigned name
	public void getNameTest() {
		final String NAME = "John";
		Person<Salesperson> person = new Salesperson();
		ReflectionTestUtils.setField(person, "name", NAME);
		assertEquals(NAME, person.getName());
	}

	@Test
	//Checks if a sale was properly added to salesperson' sales list
	public void addSaleTest() {
		final Long ID = 1L;
		Salesperson salesperson = new Salesperson();
		Sale sale = new Sale();
		ReflectionTestUtils.setField(sale, "products", new ArrayList<Product>());
		ReflectionTestUtils.setField(sale, "products", new ArrayList<Product>());
		ReflectionTestUtils.setField(sale, "id", ID);
		salesperson.addSale(sale);
		assertSame(salesperson.getSales().get(0), sale);
	}

	
	@Test
	//Checks if new salesperson sales list is empty
	public void getSalesEmptyTest() {
		Salesperson salesperson = new Salesperson();
		assertTrue(salesperson.getSales().isEmpty());
	}
	
}
	