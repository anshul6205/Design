package dataProvider;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pageObjects.OrderDetails;
import pageObjects.OrderValues;
@Listeners(SeleniumPractice.ItestListeners.class)
public class CreateOrder {
	APICallsForToken tokens=new APICallsForToken();
	APICallsForCreatingProduct or=new APICallsForCreatingProduct();
	
	@Test
	public String CreateOrderForProduct() {
    RequestSpecification create=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
	.addHeader("authorization", tokens.tokens())
	.setContentType(ContentType.JSON).build();
    
    OrderValues value=new OrderValues();
    value.setCountry("India");
    value.setProductOrderedId(or.createProduct());
    
    List<OrderValues> OrderDetailsadd=new ArrayList<OrderValues>();
    OrderDetailsadd.add(value);
    
    OrderDetails add=new OrderDetails();
    add.setOrders(OrderDetailsadd);
    
    RequestSpecification specs = given().log().all().spec(create).body(add);
    String order = specs.when().post("/api/ecom/order/create-order").then().log().all()
    .extract().response().asString();
	 
    System.out.println(order);
    return order;
	}
}
