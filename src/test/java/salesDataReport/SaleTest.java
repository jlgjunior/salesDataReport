package salesDataReport;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import models.Sale;

public class SaleTest {

	@Test
	public void getIdTest() {
		final Integer ID = 148;
		Sale sale = new Sale();
		assertEquals(ID, sale.getId());
	}
}
