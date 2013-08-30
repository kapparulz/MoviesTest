package dk.kea.si.movies.gateways;

import java.io.FileInputStream;
import java.util.Properties;

public class GetApiKeys {
	public static String getRottenTomatoesApiKey()
	{
		try {
			Properties pro = new Properties();
			pro.load(ClassLoader.getSystemResourceAsStream("settings.ini"));
			return pro.getProperty("rottentomatoes-api-key");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static String getGoogleApiKey()
	{
		try {
			Properties pro = new Properties();
			pro.load(ClassLoader.getSystemResourceAsStream("settings.ini"));
			return pro.getProperty("google-api-key");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
