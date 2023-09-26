package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//*[@type='email']")
    WebElement Useremail;
	
	@FindBy(how=How.XPATH, using="//*[@type='password']")
	WebElement Password;
	
	@FindBy(how=How.XPATH, using="//*[@type='submit']")
	WebElement loginLink;
	
	public void setUseremail(String usermail) {
		Useremail.sendKeys(usermail);
	}
	
	public void setUserpassword(String password) {
		Password.sendKeys(password);
	}
	
	public void ClickLogin() {
		loginLink.click();
	}
	

}
