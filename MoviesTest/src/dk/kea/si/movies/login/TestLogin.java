package dk.kea.si.movies.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class TestLogin {
	
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
//		assertElementPresent("janrain-google");
//		clickElementByXPath("//li[@id='janrain-google']");
		assertElementPresent("janrain-yahoo");
		clickElementByXPath("//li[@id='janrain-yahoo']");
		sleep(5000);
		assertWindowCountEquals(2);
		assertWindowPresentWithTitle("Sign in to Yahoo!");
		gotoWindowByTitle("Sign in to Yahoo!");
		setTextField("login", "manggangbang@yahoo.dk");
		setTextField("passwd", "imacopuidiot88");
		submit();
		
		assertElementPresent("username");
		IElement username = getElementById("username");
		
		assertTrue(username.getAttribute("value").contains("manggangbang@yahoo.dk"));
		
	}
	
	private void sleep(int t)
	{
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
