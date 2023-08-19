package RePractice;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class CookiesAndHeaders {
	
	@Test
	public void TestCookiesAndHeader() {
		RestAssured.given()
		
		.when()
		.get("https://www.google.com")
		.then()
		.statusCode(200)
		.log().all()
		.cookie("ACK", "Gangadaran");
		

	}
	
	@Test
	public void getCookies() {
		Response response = RestAssured.given()
		
		.when()
		.get("https://www.google.com");
		
		
		String cookie = response.getCookie("ACK");
		
		Map<String, String> cookies = response.getCookies();
		Iterator<Entry<String, String>> cookees = cookies.entrySet().iterator();
		while(cookees.hasNext()) {
			Entry<String, String> cookie1 = cookees.next();
			System.out.println(cookie1.getKey() +" "+ cookie1.getValue());
		}}
		
		@Test
		public void testHeaders() {
			Response response = RestAssured.given()
			
			.when()
			.get("https://reqres.in/api/users?page=2");
			String header = response.header("content-type");
			Headers headers = response.headers();
			
			for(Header c:headers) {
				System.out.println(c.getName() +":: "+ c.getValue());
			}
			
			
			
			
			
		

	}

}
