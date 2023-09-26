package RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class RestAssuredPractice {
	
	Body bod=new Body();
	
	public void Practice() {
		
		bod.setCity("Delhi");
		bod.setName("Ravi");
	
	RequestSpecification res=new RequestSpecBuilder().setBaseUri("abc.com")
			.build();
	
	RequestSpecification res1=given().spec(res).auth().basic("auth", "password").body(bod);
	
	String result=res1.when().post().then().statusCode(200).log().all().extract().response()
			.asString();
	
	System.out.println(result);
	
	JsonPath js=new JsonPath(result);
	js.get("");
	
	
	}
	

}
