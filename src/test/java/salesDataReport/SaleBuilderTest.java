package salesDataReport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.SaleBuilder;
import models.Sale;

public class SaleBuilderTest {

		@Test
		public void getIdTest() {
			final Integer ID = 1;
			SaleBuilder saleBuilder = new SaleBuilder();
			ReflectionTestUtils.setField(saleBuilder, "id", ID);
			assertEquals(ID, saleBuilder.getId());
		}
		
		@Test
		public void setIdTest() {
			final Integer ID = 1;
			SaleBuilder saleBuilder = new SaleBuilder();
			saleBuilder.setId(ID);
			assertEquals(ID, saleBuilder.getId());
		}
		
		@Test
		public void getProductsTest() {
			final String PRODUCTS = "1-10-100,2-30-2.50,3-40-3.10";
			SaleBuilder saleBuilder = new SaleBuilder();
			ReflectionTestUtils.setField(saleBuilder, "products", PRODUCTS);
			assertEquals(PRODUCTS, saleBuilder.getProducts());
		}
		
		@Test
		public void setCnpjTest() {
			final String PRODUCTS = "1-10-100,2-30-2.50,3-40-3.10";
			SaleBuilder saleBuilder = new SaleBuilder();
			saleBuilder.setProducts(PRODUCTS);
			assertEquals(PRODUCTS, saleBuilder.getProducts());
		}
		
		@Test
		public void buildTest() {
			final Integer ID = 1;
			final String PRODUCTS = "1-10-100,2-30-2.50,3-40-3.10";
			Sale sale = new Sale();
			ReflectionTestUtils.setField(sale, "id", ID);
			SaleBuilder SaleBuilder = new SaleBuilder();
			assertEquals(sale, 
					SaleBuilder.setId(ID).setProducts(PRODUCTS).build());
		}
}
