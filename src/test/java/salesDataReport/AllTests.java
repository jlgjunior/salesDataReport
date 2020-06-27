package salesDataReport;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@SuiteClasses({ CustomerTest.class, 
				SalespersonTest.class,
				SaleTest.class, 
				ProductTest.class,
				SaleProductTest.class,
				CSVDataReaderServiceTest.class,
				CSVSalespersonDataTest.class,
				CSVCustomerDataTest.class,
				CSVSaleDataTest.class,
				CSVDataFactoryTest.class})

public class AllTests {

}
