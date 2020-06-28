package salesDataReport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.Product;
import models.Sale;
import models.SaleProduct;

public class SaleProductTest {

		@Test
		public void getIdTest() {
			final Integer ID = 148;
			SaleProduct saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "id", ID);
			assertEquals(ID, saleProduct.getId());
		}
		
		@Test
		public void getSaleTest() {
			Sale sale = new Sale();
			SaleProduct saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "sale", sale);
			assertSame(sale, saleProduct.getSale());
		}
		
		@Test
		public void getProductTest() {
			Product product = new Product();
			SaleProduct saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "product", product);
			assertSame(product, saleProduct.getProduct());
		}

		@Test
		public void getPriceTest() {
			final Float PRICE = 148f;
			SaleProduct saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "price", PRICE);
			assertEquals(PRICE, saleProduct.getPrice());
		}
		
		@Test
		public void getQuantityTest() {
			final Integer QUANTITY = 148;
			SaleProduct saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "quantity", QUANTITY);
			assertEquals(QUANTITY, saleProduct.getQuantity());
		}
		
}
