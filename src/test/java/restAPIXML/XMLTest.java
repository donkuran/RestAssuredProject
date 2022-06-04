package restAPIXML;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {

	@Test
	public void test1() {
		
		RestAssured.given()
					.baseUri("https://chercher.tech/sample/api/books.xml")
					.when()
					.get()
					.then()
					.log()
					.body()
					.log()
					.status()
					.statusCode(200); //assertion
	}
	
	@Test
	public void test2() {
		
		Response response = RestAssured.given()
					.baseUri("https://chercher.tech/sample/api/books.xml")
					.when()
					.get();
		
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		
		System.out.println("All the books are: " + books.toString());
		
		System.out.println("First Book is: " + books.get(0).toString());
		
		System.out.println("Second Book is: " + books.get(1).toString());
		
		System.out.println("Language of first book is: " + books.get(0).getAttribute("lang"));
		
		System.out.println("Language of second book is: " + books.get(1).getAttribute("lang"));

	}
	
	@Test
	public void test3() {
		
		Response response = RestAssured.given()
					.baseUri("https://chercher.tech/sample/api/books.xml")
					.when()
					.get();
		
		NodeChildrenImpl authors = response.then().extract().path("bookstore.book.author");
		
		System.out.println("All the authors are: " + authors.toString());
		
		System.out.println("First author is: " + authors.get(0).toString());
		
		System.out.println("Second author is: " + authors.get(1).toString());

	}
	
	@Test
	public void test4() {
		
		Response response = RestAssured.given()
					.baseUri("https://chercher.tech/sample/api/books.xml")
					.when()
					.get();
		
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		
		for(String i:books) {
			
            System.out.println("Book Title: " + i);
        }
		
		for(int i = 0; i < books.size(); i++) {
			
			System.out.println("Book Title: " + books.get(i).toString());
		}

		NodeChildrenImpl prices = response.then().extract().path("bookstore.book.price");
		
		System.out.println("First price is: " + prices.get(0).children().get("paperback").toString());
		
	}
}
