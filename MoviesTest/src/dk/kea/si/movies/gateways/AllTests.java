package dk.kea.si.movies.gateways;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dk.kea.si.movies.login.AuthTest;

@RunWith(Suite.class)
@SuiteClasses({ GoogleGatewayTest.class, RottenGatewayTest.class,
		WikiGatewayTest.class, AuthTest.class })
public class AllTests {

}
