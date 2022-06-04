package restBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequestBDD {

	@Test
	public void test1() {
		
		Map<String, Object> MapObj = new HashMap<String, Object>();
		
		MapObj.put("name", "Rasta");
		MapObj.put("salary", "20000");
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(MapObj)
					.when()
					.put("/16")
					.then()
					.log()
					.body()
					.log()
					.status()
					.statusCode(200) //assertion status code
					.body("name", Matchers.equalTo("Rasta")); //assertion new name

	}
}
