package salesDataReport;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.CSVData;
import models.CSVSaleData;

public class CSVSaleDataTest {

	@Test
	public void loadDataTest() {
		String[] data = {"003", "10", 
				         "[1-10-100,2-30-2.50,3-40-3.10]", "Pedro"};
		CSVData saleData = new CSVSaleData();
		assertTrue(saleData.loadData(data));
	}

	@Test
	public void getSalespersonNameTest() {
		final String SALESPERSON_NAME = "Pedro";
		String[] data = {"003", "10", 
				         "[1-10-100,2-30-2.50,3-40-3.10]", SALESPERSON_NAME};
		CSVSaleData saleData = new CSVSaleData();
		saleData.loadData(data);
		assertEquals(SALESPERSON_NAME, saleData.getSalespersonName());
	}

	@Test
	public void getIdTest() {
		final Integer ID = 10;
		String[] data = {"003", "10", 
				         "[1-10-100,2-30-2.50,3-40-3.10]", "Pedro"};
		CSVSaleData saleData = new CSVSaleData();
		saleData.loadData(data);
		assertEquals(ID, saleData.getId());
	}

	@Test
	public void getProductsTest() {
		final String[] PRODUCTS = {"1-10-100","2-30-2.50","3-40-3.10"};
		String[] data = {"003", "10", 
				         "[1-10-100,2-30-2.50,3-40-3.10]", "Pedro"};
		CSVSaleData saleData = new CSVSaleData();
		saleData.loadData(data);
		assertArrayEquals(PRODUCTS, saleData.getProducts());
	}
	
}
