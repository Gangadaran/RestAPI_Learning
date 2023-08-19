package RePractice;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ParsingResponseBody {
	
	@Test
	public void ParsingBody() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON);
        Response response = request.get();
        
     
        
        
        
        
        
        
        // we use json path 
//        List<Object> list = response.jsonPath().getList("data.email");
//        System.out.println(list);
        
        //       String string = response.jsonPath().get("data[1].email").toString();
//       System.out.println(string);
        
      // We can directly do validation Using then method
        
//        response.then().assertThat().statusCode(200)
//        .cookie("contentType", "Json");   // Validation
//        
//        Assert.assertEquals(response.getStatusCode(), 200);
        
        
        
        
	}
	
	@Test
	public void ParsingBodyUsingJsonObject() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON);
        Response response = request.get();
        
        JSONObject json = new JSONObject(response.asString());
        
       
        
       HashMap<String, String> map = new HashMap<>();
        
        map.put("email", json.getJSONArray("data").getJSONObject(0).get("email").toString());
        map.put("first_name", json.getJSONArray("data").getJSONObject(0).get("first_name").toString());
        map.put("last_name", json.getJSONArray("data").getJSONObject(0).get("last_name").toString());
        System.out.println(map.get("email"));
        System.out.println(map.get("first_name"));
        System.out.println(map.get("last_name"));
        
        Assert.assertEquals("george.bluth@reqres.in", map.get("email"));
        Assert.assertEquals("George", map.get("first_name"));
        Assert.assertEquals("Bluth", map.get("last_name"));
        
        
        
        
        
        
        
        
        }

}
