package dataProvider;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

@Listeners(SeleniumPractice.ItestListeners.class)
public class LoginTest extends TestBase{
	
	
	@Test
	public void userLogin() {
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.setUseremail(getUseremail());
		lp.setUserpassword(getUserpassword());
		lp.ClickLogin();
	}
	
	@Test(dependsOnMethods="userLogin")
	public void HomePageVerify() {
		HomePage Home=PageFactory.initElements(driver, HomePage.class);
		Home.Verifypage();
	}
	
	

}
