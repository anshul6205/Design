package dataProvider;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pageObjects.LoginReturns;

@Listeners(SeleniumPractice.ItestListeners.class)
public class APICallsForToken extends ConfigFileReader {
	Loginrequest rqst = new Loginrequest();

	@Test
	public String tokens() {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		rqst.setUserEmail("anshulprabhakar6205@gmail.com");
		rqst.setUserPassword("cwMj@3b4AsKU");

		RequestSpecification reqLogin = given().spec(req).body(rqst).log().all();

		LoginReturns log = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response()
				.as(LoginReturns.class);

		return log.getToken();

	}
	
	public String userID() {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		rqst.setUserEmail("anshulprabhakar6205@gmail.com");
		rqst.setUserPassword("cwMj@3b4AsKU");

		RequestSpecification reqLogin = given().spec(req).body(rqst).log().all();

		LoginReturns log = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response()
				.as(LoginReturns.class);

		return log.getUserId();

	}
}
