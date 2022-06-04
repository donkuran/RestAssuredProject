package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequestWithFile {

	@Test
	public void test7() throws IOException {

			RestAssured.baseURI = "http://localhost:3000/employees";
			
			byte[] dataBytes = Files.readAllBytes(Paths.get("putData.json"));
			
			RequestSpecification request = RestAssured.given();
			
			Response response =request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(dataBytes)
									.put("/8");
			
			String ResponseBody = response.getBody().asString();
			
			System.out.println(ResponseBody);
			
			int ResponseCode = response.getStatusCode();

			Assert.assertEquals(ResponseCode, 200);
	}
}
