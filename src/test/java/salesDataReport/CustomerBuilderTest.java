package salesDataReport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import builders.CustomerBuilder;
import models.Customer;

public class CustomerBuilderTest {

		@Test
		public void getNameTest() {
			final String NAME = "Bob";
			CustomerBuilder customerBuilder = new CustomerBuilder();
			ReflectionTestUtils.setField(customerBuilder, "name", NAME);
			assertEquals(NAME, customerBuilder.getName());
		}
		
		@Test
		public void setNameTest() {
			final String NAME = "Bob";
			CustomerBuilder customerBuilder = new CustomerBuilder();
			customerBuilder.setName(NAME);
			assertEquals(NAME, customerBuilder.getName());
		}
		
		@Test
		public void getCnpjTest() {
			final String CNPJ = "01283219038";
			CustomerBuilder customerBuilder = new CustomerBuilder();
			ReflectionTestUtils.setField(customerBuilder, "cnpj", CNPJ);
			assertEquals(CNPJ, customerBuilder.getCnpj());
		}
		
		@Test
		public void setCnpjTest() {
			final String CNPJ = "01283219038";
			CustomerBuilder customerBuilder = new CustomerBuilder();
			customerBuilder.setCnpj(CNPJ);
			assertEquals(CNPJ, customerBuilder.getCnpj());
		}

		@Test
		public void getAreaTest() {
			final String AREA = "51";
			CustomerBuilder customerBuilder = new CustomerBuilder();
			ReflectionTestUtils.setField(customerBuilder, "area", AREA);
			assertEquals(AREA, customerBuilder.getArea());
		}
		
		@Test
		public void setAreaTest() {
			final String AREA = "51";
			CustomerBuilder customerBuilder = new CustomerBuilder();
			customerBuilder.setArea(AREA);
			assertEquals(AREA, customerBuilder.getArea());
		}
		
		@Test
		public void buildTest() {
			final String AREA = "51";
			final String CNPJ = "01283219038";
			final String NAME = "Bob";
			Customer customer = new Customer();
			ReflectionTestUtils.setField(customer, "cnpj", CNPJ);
			ReflectionTestUtils.setField(customer, "name", NAME);
			ReflectionTestUtils.setField(customer, "area", AREA);
			CustomerBuilder customerBuilder = new CustomerBuilder();
			assertEquals(customer, 
					customerBuilder.setCnpj(CNPJ).setName(NAME).setArea(AREA).build());
		}
}
