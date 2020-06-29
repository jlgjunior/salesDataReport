package salesDataReport;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.SaleBuilder;
import models.Product;
import models.Sale;

public class SaleBuilderTest {

		@Test
		public void getIdTest() {
			final Long ID = 1L;
			SaleBuilder saleBuilder = new SaleBuilder();
			ReflectionTestUtils.setField(saleBuilder, "id", ID);
			assertEquals(ID, saleBuilder.getId());
		}
		
		@Test
		public void setIdTest() {
			final Long ID = 1L;
			SaleBuilder saleBuilder = new SaleBuilder();
			saleBuilder.setId(ID);
			assertEquals(ID, saleBuilder.getId());
		}
		
		@Test
		public void getProductsTest() {
			List<Product> saleProducts = new ArrayList<Product>();
			saleProducts.add(new Product());
			saleProducts.add(new Product());
			SaleBuilder saleBuilder = new SaleBuilder();
			ReflectionTestUtils.setField(saleBuilder, "products", saleProducts);
			assertSame(saleProducts, saleBuilder.getProducts());
		}
		
		@Test
		public void setProductsTest() {
			List<Product> saleProducts = new ArrayList<Product>();
			saleProducts.add(new Product());
			saleProducts.add(new Product());
			SaleBuilder saleBuilder = new SaleBuilder();
			saleBuilder.setProducts(saleProducts);
			assertSame(saleProducts, saleBuilder.getProducts());
		}
		
		@Test
		public void buildTest() {
			List<Product> saleProducts = new ArrayList<Product>();
			saleProducts.add(new Product());
			saleProducts.add(new Product());
			final Long ID = 1L;
			Sale sale = new Sale();
			ReflectionTestUtils.setField(sale, "id", ID);
			ReflectionTestUtils.setField(sale, "products", saleProducts);
			SaleBuilder SaleBuilder = new SaleBuilder();
			assertEquals(sale, 
					SaleBuilder.setId(ID).setProducts(saleProducts).build());
		}
}
