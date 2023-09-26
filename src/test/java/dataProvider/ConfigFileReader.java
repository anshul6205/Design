package dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Listeners;

@Listeners(SeleniumPractice.ItestListeners.class)
public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "Configs//Configuration.properties";

	public ConfigFileReader() {
		// Initialize the properties object in the constructor
		properties = new Properties();
		Configreader();
	}

	private void Configreader() {
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getDriverPath() {
		String driverpath = properties.getProperty("driverPath");
		return driverpath;
	}

	public String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	public Long getImplicitWait() {
		String wait = properties.getProperty("ImplicitlyWait");
		return Long.parseLong(wait);
	}
	
	public String getUseremail() {
		String Useremail=properties.getProperty("useremail");
		return Useremail;
	}
	
	public String getUserpassword() {
		String Userpassword=properties.getProperty("userpassword");
		return Userpassword;
	}
	
	
}
