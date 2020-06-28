package salesDataReport;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.SaleBuilder;
import models.Sale;
import models.SaleProduct;

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
		public void getSaleProductsTest() {
			List<SaleProduct> saleProducts = new ArrayList<SaleProduct>();
			saleProducts.add(new SaleProduct());
			saleProducts.add(new SaleProduct());
			SaleBuilder saleBuilder = new SaleBuilder();
			ReflectionTestUtils.setField(saleBuilder, "saleProducts", saleProducts);
			assertSame(saleProducts, saleBuilder.getSaleProducts());
		}
		
		@Test
		public void setSaleProductsTest() {
			List<SaleProduct> saleProducts = new ArrayList<SaleProduct>();
			saleProducts.add(new SaleProduct());
			saleProducts.add(new SaleProduct());
			SaleBuilder saleBuilder = new SaleBuilder();
			saleBuilder.setSaleProducts(saleProducts);
			assertSame(saleProducts, saleBuilder.getSaleProducts());
		}
		
		@Test
		public void buildTest() {
			List<SaleProduct> saleProducts = new ArrayList<SaleProduct>();
			saleProducts.add(new SaleProduct());
			saleProducts.add(new SaleProduct());
			final Integer ID = 1;
			Sale sale = new Sale();
			ReflectionTestUtils.setField(sale, "id", ID);
			ReflectionTestUtils.setField(sale, "saleProducts", saleProducts);
			SaleBuilder SaleBuilder = new SaleBuilder();
			assertEquals(sale, 
					SaleBuilder.setId(ID).setSaleProducts(saleProducts).build());
		}
}
