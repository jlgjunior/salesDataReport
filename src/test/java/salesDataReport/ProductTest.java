package salesDataReport;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import models.Product;

public class ProductTest {

		
	@Test
	public void getIdTest() {
		Integer id = 11;
		Product product = new Product(id);
		assertEquals(id, product.getId());
	}


}
