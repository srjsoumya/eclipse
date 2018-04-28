package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponceTest {
	@Test
	public void responseCode()
	{
		String url="https://jsonplaceholder.typicode.com/posts/1";
		Response resp=RestAssured.get(url);
		int code=resp.getStatusCode();
		System.out.println("the status code is "+code);
		Assert.assertEquals(code, 200);
	}
	@Test
	public void responceBody()
	{
		String url="https://jsonplaceholder.typicode.com/posts/1";
		Response resp=RestAssured.get(url);
		String body=resp.asString();
		System.out.println("Data is "+body);
		System.out.println("Resonse time is "+resp.getTime());
	}
	

}
