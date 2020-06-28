package salesDataReport;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.SaleProductBuilder;
import models.Product;
import models.SaleProduct;

public class SaleProductBuilderTest {

		@Test
		public void getQuantityTest() {
			final Integer QUANTITY = 1;
			SaleProductBuilder saleProductBuilder = new SaleProductBuilder();
			ReflectionTestUtils.setField(saleProductBuilder, "quantity", QUANTITY);
			assertEquals(QUANTITY, saleProductBuilder.getQuantity());
		}
		
		@Test
		public void setQuantityTest() {
			final Integer QUANTITY = 1;
			SaleProductBuilder saleProductBuilder = new SaleProductBuilder();
			saleProductBuilder.setQuantity(QUANTITY);
			assertEquals(QUANTITY, saleProductBuilder.getQuantity());
		}
		
		@Test
		public void getPriceTest() {
			final Float PRICE = 1f;
			SaleProductBuilder saleProductBuilder = new SaleProductBuilder();
			ReflectionTestUtils.setField(saleProductBuilder, "price", PRICE);
			assertEquals(PRICE, saleProductBuilder.getPrice());
		}
		
		@Test
		public void setPriceTest() {
			final Float PRICE = 1f;
			SaleProductBuilder saleProductBuilder = new SaleProductBuilder();
			saleProductBuilder.setPrice(PRICE);
			assertEquals(PRICE, saleProductBuilder.getPrice());
		}
		
		@Test
		public void getProductTest() {
			Product product = new Product();
			SaleProductBuilder saleProductBuilder = new SaleProductBuilder();
			ReflectionTestUtils.setField(saleProductBuilder, "product", product);
			assertSame(product, saleProductBuilder.getProduct());
		}
		
		@Test
		public void setProductTest() {
			Product product = new Product();
			SaleProductBuilder saleProductBuilder = new SaleProductBuilder();
			saleProductBuilder.setProduct(product);
			assertSame(product, saleProductBuilder.getProduct());
		}
		
		@Test
		public void buildTest() {
			final Integer QUANTITY = 1;
			final Float PRICE = 1f;
			Product product = new Product();
			SaleProduct saleProduct = new SaleProduct();
			ReflectionTestUtils.setField(saleProduct, "price", PRICE);
			ReflectionTestUtils.setField(saleProduct, "quantity", QUANTITY);
			ReflectionTestUtils.setField(saleProduct, "product", product);
			SaleProductBuilder saleProductBuilder = new SaleProductBuilder();
			assertEquals(saleProduct, 
					saleProductBuilder.setQuantity(QUANTITY).setPrice(PRICE).setProduct(product).build());
		}
}
