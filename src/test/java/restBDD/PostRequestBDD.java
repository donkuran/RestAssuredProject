package restBDD;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PostRequestBDD {

	@Test
	public void test1() {
		

		Map<String, Object> MapObj = new HashMap<String, Object>();
		
		MapObj.put("name", "Rudo");
		MapObj.put("salary", "100000");
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(MapObj)
					.when()
					.post("/create")
					.then()
					.log()
					.body()
					.log()
					.status()
					.statusCode(201) //assertion
					.body("name", Matchers.equalTo("Rudo"));

	}
}
