package dataProvider;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

@Listeners(SeleniumPractice.ItestListeners.class)
public class DeleteCalls {

	APICallsForToken token = new APICallsForToken();
	APICallsForCreatingProduct product = new APICallsForCreatingProduct();
	
	@Test	
	public void DeleteProduct() {
		RequestSpecification request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	    .addHeader("authorization", token.tokens()).setContentType(ContentType.JSON)
	    .build();
		
		RequestSpecification deleteprod = given().log().all().spec(request);
		
		String delp=deleteprod.when().delete("/api/ecom/product/delete-product/"+product.createProduct())
		.then().log().all().extract().response().asString();
		
		JsonPath js1=new JsonPath(delp);
		
		System.out.println(js1);
		
	
	
	}

}
