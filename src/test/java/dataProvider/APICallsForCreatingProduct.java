package dataProvider;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

@Listeners(SeleniumPractice.ItestListeners.class)
public class APICallsForCreatingProduct {

	APICallsForToken token = new APICallsForToken();

	@Test
	public String createProduct() {
		RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token.tokens()).build();

		RequestSpecification addProd = given().log().all().spec(spec).param("productName", "Laptop")
				.param("productAddedBy", token.userID()).param("productCategory", "fashion")
				.param("productSubCategory", "Shirts").param("productPrice", "11500")
				.param("productDescription", "Lenova").param("productFor", "men")
				.multiPart("productImage", new File("C:\\Users\\anshu\\Downloads\\Image111.jpg"));

		String responseAdd = addProd.when().post("/api/ecom/product/add-product").then().log().all().extract()
				.response().asString();

		JsonPath js = new JsonPath(responseAdd);
		System.out.println(js.get("productId"));
		return js.get("productId");
	}

}
