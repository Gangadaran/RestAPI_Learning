 package RePractice;

import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MutipleWaysOfPayLoad {
	
	/*
	 * HashMap
	 * Using json or gson
	 * Using Pojo
	 * Using external Json file
	 * 
	 */
	
	// Using HashMap
	@Test
	public void PostRequestUsingMap() {
		HashMap<String,String> map = new HashMap<>();
		map.put("name", "morpheus");
		map.put("job", "leader");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		//RestAssured.authentication = RestAssured.basic(null, null);
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).when().body(map);
		Response response = request.post();
		response.then().assertThat().statusCode(201).log().all();

	}
	
	@Test
	public void PostRequestUsingJson() {
		JSONObject json = new JSONObject();
		json.put("name", "morpheus");
		json.put("job", "leader");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		//RestAssured.authentication = RestAssured.basic(null, null);
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).when().body(json);
		Response response = request.post();
		response.then().assertThat().statusCode(201).log().all();

	}
	
	
	@Test
	public void PostRequestUsingPojo() {
		Pojo pojo = new Pojo();
		pojo.setName("Gangadaran");
		pojo.setJob("SDET");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		//RestAssured.authentication = RestAssured.basic(null, null);
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).when().body(pojo);
		Response response = request.post();
		response.then().assertThat().statusCode(201).log().all();

	}
	
	@Test
	public void PostRequestUsingFile() {
		File file = new File("./src/test/resources/data.json");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		//RestAssured.authentication = RestAssured.basic(null, null);
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).when().body(file);
		Response response = request.post();
		response.then().assertThat().statusCode(201).log().all();

	}

}
