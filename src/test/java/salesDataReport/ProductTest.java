package salesDataReport;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.Product;

public class ProductTest {

		
	@Test
	public void getIdTest() {
		final Long ID = 11L;
		Product product = new Product();
		ReflectionTestUtils.setField(product, "id", ID);
		assertEquals(ID, product.getId());
	}


}
