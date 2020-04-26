package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExtractNodeText {
	@Test
	public void verifyCityINJsonResponse()
	{
		//RestApi Testing
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Bangalore");
		JsonPath jsonPathEvaluator =  response.jsonPath();
		String city = jsonPathEvaluator.get("City");
		System.out.println("City Received from Response " + city);
		Assert.assertEquals("Bengaluru", city);
		String temp =jsonPathEvaluator.get("Temperature");
		System.out.println("Temp Received from Response " + temp);
		String windSpeed = jsonPathEvaluator.get("WindSpeed");
		System.out.println("WindSpeed Received from Response " + windSpeed);
		
		
		
		
	}
}
