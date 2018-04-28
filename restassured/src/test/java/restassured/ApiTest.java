package restassured;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	@Test
	public void apiResponse() {
		String path="http://samples.openweathermap.org/data/2.5/weather";
		RestAssured.baseURI = path;
		RequestSpecification httpReqst = RestAssured.given();
		Response response = httpReqst.get("?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22"); //if we want specific data from json 
		//Take header and authentication 

		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println("Response code is " + code);
		
		
		String type = response.getContentType();
		System.out.println("Response type is " + type);

		String body = response.asString();
		System.out.println("Response body is " + body);
		
		JsonPath json=response.jsonPath();
		ArrayList<Object> lst=json.get("weather");
		for(int i=0;i<lst.size();i++)
		{
			System.out.println(lst.get(i));
		}
		
		Object visibility=json.get("visibility");
		System.out.println(visibility);

	}
	@Test
	public void apiRespo()
	{
		String path="https://jsonplaceholder.typicode.com/comments";
		RestAssured.baseURI = path;
		RequestSpecification httpReqst = RestAssured.given();
		Response resp=httpReqst.get("/2");  //take header 
		
		int code = resp.getStatusCode();
		Assert.assertEquals(code, 200);
		System.out.println("Response code is " + code);
		
		
		String type = resp.getContentType();
		System.out.println("Response type is " + type);

		String body = resp.asString();
		System.out.println("Response body is " + body);
		
		JsonPath json=resp.jsonPath();
		String email=json.get("email");
		System.out.println("email is "+email);
		
		
	}

}
