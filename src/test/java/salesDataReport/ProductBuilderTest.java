package salesDataReport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.ProductBuilder;
import models.Product;

public class ProductBuilderTest {

		@Test
		public void getIdTest() {
			final Integer ID = 1;
			ProductBuilder productBuilder = new ProductBuilder();
			ReflectionTestUtils.setField(productBuilder, "id", ID);
			assertEquals(ID, productBuilder.getId());
		}
		
		@Test
		public void setIdTest() {
			final Integer ID = 1;
			ProductBuilder productBuilder = new ProductBuilder();
			productBuilder.setId(ID);
			assertEquals(ID, productBuilder.getId());
		}
		
		@Test
		public void buildTest() {
			final Integer ID = 1;
			Product product = new Product();
			ReflectionTestUtils.setField(product, "id", ID);
			ProductBuilder productBuilder = new ProductBuilder();
			assertEquals(product, 
					productBuilder.setId(ID).build());
		}
}
