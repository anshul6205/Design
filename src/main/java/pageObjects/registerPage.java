package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class registerPage {

	WebDriver driver;

	public registerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@class='text-reset']")
	WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//*[@type='firstName']")
	public WebElement Name;

	@FindBy(how = How.XPATH, using = "//*[@type='lastName']")
	WebElement Lastname;
	
	@FindBy(how = How.XPATH, using = "//*[@type='email']")
	WebElement Email;
	
	@FindBy(how = How.XPATH, using = "//*[@type='text']")
	WebElement phoneNumber;
	
	@FindBy(how = How.XPATH, using = "//select[@formcontrolname='occupation']")
	WebElement Occupation;
	
	@FindBy(how = How.XPATH, using = "//*[@type='radio' and @value='Male']")
	WebElement Gender;	
	
	@FindBy(how = How.XPATH, using = "(//*[@type='password'])[1]")
	WebElement Password;
	
	@FindBy(how = How.XPATH, using = "(//*[@type='password'])[2]")
	WebElement ConfirmPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@type='checkbox']")
	WebElement ConfirmCheckbox;
	
	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	WebElement Register;
	
	Faker fake=new Faker();
	
	public void clickOnRegisterButton() {
		registerLink.click();
	}

	public void SetName() {
		Name.click();
		Name.sendKeys(fake.name().firstName());
	}
	
	public void SetLastName() {
		Lastname.click();
		Lastname.sendKeys(fake.name().lastName());
	}
	
	public void SetEmail() {
		Email.click();
		Email.sendKeys(fake.internet().emailAddress());
	}
	
	public void SetPhoneNumber() {
		phoneNumber.click();
		phoneNumber.sendKeys(fake.phoneNumber().cellPhone());
	}
	
	public void SetOccupation() {
		Select sel=new Select(Occupation);
		Occupation.click();
		sel.selectByIndex(4);
	}
	
	public void SetGender() {
		Gender.click();
	}
	
	public void SetPassword() {
		Password.click();
		Password.sendKeys(fake.internet().password());
	}
	
	public void SetConfirmPassword() {
		ConfirmPassword.click();
		ConfirmPassword.sendKeys(fake.internet().password());
	}
	
	public void SetCheckbox() {
		ConfirmCheckbox.click();
	}
	
	public void SetSubmit() {
		Register.click();
	}
}
