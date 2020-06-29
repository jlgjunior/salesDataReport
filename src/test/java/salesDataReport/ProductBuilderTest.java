package salesDataReport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.ProductBuilder;
import models.Product;

public class ProductBuilderTest {

		@Test
		public void getIdTest() {
			final Long ID = 1L;
			ProductBuilder productBuilder = new ProductBuilder();
			ReflectionTestUtils.setField(productBuilder, "id", ID);
			assertEquals(ID, productBuilder.getId());
		}
		
		@Test
		public void setIdTest() {
			final Long ID = 1L;
			ProductBuilder productBuilder = new ProductBuilder();
			productBuilder.setId(ID);
			assertEquals(ID, productBuilder.getId());
		}
		
		@Test
		public void buildTest() {
			final Long ID = 1L;
			Product product = new Product();
			ReflectionTestUtils.setField(product, "id", ID);
			ProductBuilder productBuilder = new ProductBuilder();
			assertEquals(product, 
					productBuilder.setId(ID).build());
		}
}
