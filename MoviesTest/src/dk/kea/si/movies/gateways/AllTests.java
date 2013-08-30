package dk.kea.si.movies.gateways;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GoogleGatewayTest.class, RottenGatewayTest.class,
		WikiGatewayTest.class })
public class AllTests {

}
