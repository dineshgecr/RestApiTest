package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class RegisterationPost {
@Test
	public void RegisterationONSucessful() 
	{
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "DINESH");
		requestParams.put("LastName", "DEWANGAN");
		requestParams.put("User", "dineshgecr");
		requestParams.put("pass", "password1");
		requestParams.put("Email", "dinesh@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String sucessCode = response.jsonPath().get("SuccessCode"); 
		Assert.assertEquals("Correct Success code was returned", sucessCode, "OPERATION_SUCCESS");
		
		
	}
}
