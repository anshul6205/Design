package dataProvider;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(SeleniumPractice.ItestListeners.class)
public class TestBase extends ConfigFileReader{
	
	public static WebDriver driver=null;
	
	@BeforeSuite
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", getDriverPath());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitWait()));
		driver.get(getURL());
		
	}
	
	@AfterSuite
	public void CloseBrowser() {
		TestBase.driver.quit();
	}

}
