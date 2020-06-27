package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.SaleProduct;

public class SaleProductTest {

		@Test
		public void getIdTest() {
			final Integer ID = 148;
			SaleProduct saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "id", ID);
			assertEquals(ID, saleProduct.getId());
		}
}
