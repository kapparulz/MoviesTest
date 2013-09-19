package dk.kea.si.movies.login;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class AuthTest {
	
	@Before
	public void prepare() {
		setBaseUrl("http://localhost:8080/Movies");
		//setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
		//setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_WEBDRIVER);
	}

	@Test
	public void testLogin() {
		beginAt("/default.jsp"); // Open the browser on
								// http://localhost:8080/test/home.xhtml
		
		assertTitleEquals("Movies");
		assertElementPresent("janrainModal");
		String element = getElementAttributeByXPath("//div[@id='janrainModal']", "style");
		assertTrue(element.contains("display: none"));
		clickLink("login");
		element = getElementAttributeByXPath("//div[@id='janrainModal']", "style");
		assertTrue(element.contains("display: block"));

		assertElementPresent("janrain-yahoo");
		clickElementByXPath("//li[@id='janrain-yahoo']");
		assertWindowCountEquals(2);
		assertWindowPresentWithTitle("Sign in to Yahoo!");
		gotoWindowByTitle("Sign in to Yahoo!");
		setTextField("login", "testmoviehunter123@yahoo.dk");
		setTextField("passwd", "Test12345");
		
		submit(".save");
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//beginAt("/default.jsp");
		//gotoWindowByTitle("Movies");

		assertTextPresent("Logout");
		assertElementPresent("username");
		IElement username = getElementById("username");
		
		assertTrue(username
				.getTextContent()
				.contains("movie hunter"));
		
		assertElementNotPresent("login");
				
		assertElementPresent("logout");
		clickLink("logout");
		assertElementPresent("login");
	}
	


	
	@After
	public void tearDown() throws Exception {
	}

}
