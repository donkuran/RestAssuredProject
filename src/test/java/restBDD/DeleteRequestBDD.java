package restBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequestBDD {

	@Test
	public void test1() {
			
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.delete("/15") //delete employee id=16
					.then()
					.log()
					.body()
					.log()
					.status()
					.statusCode(200) //assertion
					.body("name", Matchers.equalTo(null));

	}
}
