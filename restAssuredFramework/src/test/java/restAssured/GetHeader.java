package restAssured;

import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetHeader {

	@Test
	public void getWheraterHeader()
	{
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/bangalore");
		Headers allHeaders = response.headers();
		for (Header header : allHeaders) {
			System.out.println( header.getName() +  "Value : " + header.getValue());
		}
	
		String contentType = response.getHeader("Content-Type");
		System.out.println("contentType value:" + contentType);
		String serverType = response.header("Server");
		System.out.println("serverType is:" + serverType);
		Assert.assertEquals("nginx", serverType);
		String acceptLanguage  = response.header("Content-Enconding");
		System.out.println("acceptLanaguage" + acceptLanguage);
		
	}
}
