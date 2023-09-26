package dataProvider;

import org.testng.annotations.Listeners;

@Listeners(SeleniumPractice.ItestListeners.class)
public class Loginrequest {
	
	String userEmail;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	String userPassword;
	
	
	

}
