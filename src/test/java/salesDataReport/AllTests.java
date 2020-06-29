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
				CSVDataReaderServiceTest.class,
				DataImporterServiceTest.class,
				CSVSalespersonDataTest.class,
				CSVCustomerDataTest.class,
				CSVSaleDataTest.class,
				CSVDataFactoryTest.class,
				SalespersonBuilderTest.class,
				CustomerBuilderTest.class,
				SaleBuilderTest.class,
				ProductBuilderTest.class})

public class AllTests {

}
