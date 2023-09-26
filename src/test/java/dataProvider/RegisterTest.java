package dataProvider;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.registerPage;

@Listeners(SeleniumPractice.ItestListeners.class)
public class RegisterTest extends TestBase {
	
	
	@Test(priority=1)
	public void userRegistration() throws InterruptedException {
		registerPage page=PageFactory.initElements(driver, registerPage.class);
		page.clickOnRegisterButton();
		Thread.sleep(10000);
	}
	
	@Test(dependsOnMethods="userRegistration", priority=1)
	public void EnterUserDetails() throws InterruptedException {
		registerPage page=PageFactory.initElements(driver, registerPage.class);
		/*new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.
				elementToBeSelected(page.Name));*/
		page.SetName();
		page.SetLastName();
		page.SetEmail();
		page.SetPhoneNumber();
		page.SetOccupation();
		page.SetGender();
		page.SetPassword();
		page.SetConfirmPassword();
		page.SetCheckbox();
		page.SetSubmit();
	}

}
