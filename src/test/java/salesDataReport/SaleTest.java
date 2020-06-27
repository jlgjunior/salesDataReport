package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.Product;
import models.Sale;

public class SaleTest {

	@Test
	public void getIdTest() {
		final Integer ID = 148;
		Sale sale = new Sale();
		assertEquals(ID, sale.getId());
	}
	
	@Test
	//checks if an empty sales product list is instantiated
	//upon sale creation
	public void getProductsEmptyTest() {
		final Integer ID = 148;
		Sale sale = new Sale();
		ReflectionTestUtils.setField(sale, "id", ID);
		assertTrue(sale.getProducts().isEmpty());
	}
	
	@Test
	//checks if an products object is a product
	public void addProductTest() {
		final Integer ID = 148;
		Sale sale = new Sale();
		ReflectionTestUtils.setField(sale, "id", ID);
		Product product = new Product();
		ReflectionTestUtils.setField(product, "id", ID);
		sale.addProduct(product);
		assertSame(sale.getProducts().get(0), product);
	}
	
}
