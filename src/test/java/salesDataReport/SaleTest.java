package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import models.Sale;

public class SaleTest {

	@Test
	public void getIdTest() {
		final Long ID = 148L;
		Sale sale = new Sale();
		ReflectionTestUtils.setField(sale, "id", ID);
		assertEquals(ID, sale.getId());
	}
}
