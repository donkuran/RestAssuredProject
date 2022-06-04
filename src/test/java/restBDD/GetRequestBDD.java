package restBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {

	@Test
	public void test1() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
//					.get()
					.get("/1") //get employee id=1
					.then()
					.log()
//					.all()
					.body()
//					.status()
					.statusCode(200); //assertion
	}
	
	@Test
	public void test2() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
//					.queryParam("id", "1")
//					.queryParam("name", "Pankaj")
					.when()
					.get()
					.then()
					.log()
//					.all()
					.body()
					.log()
					.status()
					.statusCode(200) //assertion
//					.body("[0].name", Matchers.equalTo("Pankaj"));  //assertion first name
					.body("[3].name", Matchers.equalTo("Fungai"));	//assertion fourth name
		
	}
	
	@Test
	public void test3() {
		
		Response response = RestAssured.given()
										.baseUri("http://localhost:3000/employees")
										.queryParam("id", "1")
										.when()
										.get();
		
		String ResponseBody = response.getBody().asString();
		
		System.out.println(ResponseBody);
		
		JsonPath jpath = response.jsonPath();
		
		List<String> names = jpath.get("name");
		
		System.out.println(names.get(0));
		
		Assert.assertEquals(names.get(0), "Pankaj");

		int ResponseCode = response.getStatusCode();

		Assert.assertEquals(ResponseCode, 200);
		
		String Header = response.getHeader("Content-Type");
		
		System.out.println(Header);
	}
}
