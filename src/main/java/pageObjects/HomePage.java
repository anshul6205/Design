package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Automation')]")
	WebElement HomeLink;
	
	
	public void Verifypage() {
		HomeLink.isDisplayed();
		Assert.assertEquals("AUTOMATION", HomeLink.getText());
	}
}
