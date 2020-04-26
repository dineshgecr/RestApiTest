package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {
	@Test
	public void getWheatherDetails(){
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest =	RestAssured.given();
//		Response response =	httpRequest.request(Method.GET,"/Bangalore");
		Response response = httpRequest.get("/Bangalore");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		int code =response.getStatusCode();
		System.out.println("Response Code is "+ code);
		System.out.println(response.getStatusLine());
		Assert.assertEquals(200, code);
		
		
	}
}
