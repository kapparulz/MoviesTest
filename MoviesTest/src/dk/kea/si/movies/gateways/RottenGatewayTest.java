package dk.kea.si.movies.gateways;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dk.kea.si.movies.domain.Movie;
import dk.kea.si.movies.gateways.RottenTomatoesGateway;

public class RottenGatewayTest {
	private String apiKey = "eu48pmstyjtehcce8rrf7nt6";

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchMovies() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindMovie() {
		String movieID = "771313870";
		Movie movie = null;
		try {
			movie = RottenTomatoesGateway.findMovie(apiKey, movieID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("IOException in findMovie() method");
		}		
		
		assertNotNull(movie);
		assertTrue(movie.getTitle().equals("Kick-Ass 2"));
	}

	@Test
	public void testFindCurrentlyInTheaters() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindComingSoon() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOpening() {
		fail("Not yet implemented");
	}

}
