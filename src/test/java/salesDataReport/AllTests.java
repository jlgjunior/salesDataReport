package salesDataReport;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerTest.class, 
				SalespersonTest.class, 
				SaleTest.class, 
				ProductTest.class})

public class AllTests {

}
