package practice;

import static io.restassured.RestAssured.given;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Cookies_Headers {
	// https://reqres.in/api/users?id=2
	
	@Test
	public void cook() {
		 Response response = given().pathParam("path", "Api")
		 .pathParam("path1", "users")
		 .queryParam("id", "2")
		 .when()
		 .get("https://reqres.in/{path}/{path1}");
		 
		 
		 Headers headers = response.getHeaders();
		 
		 for(Header head: headers) {
			 System.out.println(head.getName() +" " +head.getValue());
		 }
		 
		 
		 Map<String, String> cookies = response.getCookies();
		 
		
		 Iterator<Entry<String, String>> iterator = cookies.entrySet().iterator();
		 while(iterator.hasNext()) {
			 System.out.println(iterator.next());
		 }

	}

}
