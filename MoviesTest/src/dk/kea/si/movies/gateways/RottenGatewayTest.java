package dk.kea.si.movies.gateways;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dk.kea.si.movies.domain.Movie;
import dk.kea.si.movies.domain.MovieSearchResults;
import dk.kea.si.movies.gateways.RottenTomatoesGateway;

public class RottenGatewayTest {
	private String apiKey = null;

	@Before
	public void setUp() throws Exception {
		apiKey = GetApiKeys.getRottenTomatoesApiKey();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearchMovies() {
		MovieSearchResults movieList = null;
		try {
			movieList = RottenTomatoesGateway.searchMovies(apiKey, "gladiator", "1");
		}  catch (IOException e) {
			e.printStackTrace();
			fail("IOException in SearchMovies() method");
		}
		assertNotNull(movieList);
		assertTrue(movieList.getMovies().length > 0 );
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
		MovieSearchResults movieList = null;
		try {
			movieList=RottenTomatoesGateway.findCurrentlyInTheaters(apiKey);
		}  catch (IOException e) {
			e.printStackTrace();
			fail("IOException in findCurrentlyInTheaters() method");
		}
		assertNotNull(movieList);
		assertTrue("There was no entries in the movie array",movieList.getMovies().length > 0);
		assertTrue("The movie array did not contain correct number of entries",movieList.getMovies().length == 6);
	}

	@Test
	public void testFindComingSoon() {
		MovieSearchResults movieList = null;
		try {
			movieList=RottenTomatoesGateway.findCurrentlyInTheaters(apiKey);
		}  catch (IOException e) {
			e.printStackTrace();
			fail("IOException in findComingSoon() method");
		}
		assertNotNull(movieList);
		assertTrue("There was no entries in the movie array",movieList.getMovies().length > 0);
		assertTrue("The movie array did not contain correct number of entries",movieList.getMovies().length == 6);
	}

	@Test
	public void testFindOpening() {
		MovieSearchResults movieList = null;
		try {
			movieList=RottenTomatoesGateway.findCurrentlyInTheaters(apiKey);
		}  catch (IOException e) {
			e.printStackTrace();
			fail("IOException in findCurrentlyInTheaters() method");
		}
		assertNotNull(movieList);
		assertTrue("There was no entries in the movie array",movieList.getMovies().length > 0);
		assertTrue("The movie array did not contain correct number of entries",movieList.getMovies().length == 6);
	}

}
