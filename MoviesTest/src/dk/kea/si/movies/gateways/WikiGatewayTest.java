package dk.kea.si.movies.gateways;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dk.kea.si.movies.gateways.WikipediaGateway;

public class WikiGatewayTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWikiPage() {
		String wikiPage = WikipediaGateway.getWikiPage("gladiator", "2000");
		assertTrue(wikiPage.length() > 0);
	}

}
