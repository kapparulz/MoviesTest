package dk.kea.si.movies.gateways;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dk.kea.si.movies.domain.GoogleVideo;
import dk.kea.si.movies.gateways.GoogleGateway;

public class GoogleGatewayTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindVideos() {
		String apiKey =GetApiKeys.getGoogleApiKey();
		String searchQuery = "gladiator 2001 trailer";
		ArrayList<GoogleVideo> testList = new ArrayList<>();
		
		try {
			testList = GoogleGateway.findVideos(apiKey, searchQuery);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("IOException in findVideos() method");
		}
		
		assertTrue(testList.size() > 0);
		
	}

}
