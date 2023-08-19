package practice;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ParsingResponseBody {
	
	@Test
	public void Parsing() {
		RestAssured.baseURI = "https://reqres.in/api/unknown";
	    RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
	    Response response = request.get();
	    // response.then().log().all();
	    
	    response.then().body("data[3].name", Matchers.equalTo("aqua sky")); 
	    String object = response.jsonPath().get("data[3].name").toString();
	    System.out.println(object);
	    
	  
	    
	     JSONObject r = new JSONObject(response.asString());  // converting response to Json object
	    
	    boolean status= false;
	    
	    for (int i = 0; i < r.getJSONArray("data").length(); i++) {
			String name = r.getJSONArray("data").getJSONObject(i).get("name").toString();
			String name1 = r.getJSONArray("data").getJSONObject(i).get("id").toString();
			String name2 = r.getJSONArray("data").getJSONObject(i).get("year").toString();
			
		}
	    
	   
	    

	}

}
