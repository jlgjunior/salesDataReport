package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.Product;
import models.Sale;
import models.SaleProduct;

public class SaleProductTest {

		@Test
		public void getIdTest() {
			final Integer ID = 148;
			PersistantModel saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "id", ID);
			assertEquals(id, sale.getId());
		}
}
