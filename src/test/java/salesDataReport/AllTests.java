package salesDataReport;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(Suite.class)
@SuiteClasses({ CustomerTest.class, 
				SaleTest.class, 
				ProductTest.class,
				CSVDataReaderServiceTest.class,
				CSVSalespersonDataTest.class,
				CSVCustomerDataTest.class,
				SalespersonTest.class,
				CSVSaleDataTest.class,
				CSVDataFactoryTest.class})

public class AllTests {

}
