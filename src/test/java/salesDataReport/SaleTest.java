package salesDataReport;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import models.Sale;

public class SaleTest {

	@Test
	public void getIdTest() {
		Integer id = 148;
		Sale sale = new Sale(id);
		assertEquals(id, sale.getId());
	}
	
}
