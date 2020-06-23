package salesDataReport;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import models.Product;
import models.Sale;

public class SaleTest {

	@Test
	public void getIdTest() {
		Integer id = 148;
		Sale sale = new Sale(id);
		assertEquals(id, sale.getId());
	}
	
	@Test
	//checks if an empty sales product list is instantiated
	//upon sale creation
	public void getProductsEmptyTest() {
		Integer id = 148;
		Sale sale = new Sale(id);
		assertTrue(sale.getProducts().isEmpty());
	}
	
	@Test
	//checks if an products object is a product
	public void addProductTest() {
		Integer id = 148;
		Sale sale = new Sale(id);
		Product product = new Product(id);
		sale.addProduct(sale);
		assertSame(sale.getProducts().get(0), product);
	}
	
}
