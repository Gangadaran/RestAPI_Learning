package RePractice;

import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserilization {
   
	
	
	// POJO -> JSON
	@Test
	public void testSerialization() throws JsonProcessingException {
		Pojo pojo = new Pojo();
		pojo.setName("Gangadaran");
		pojo.setJob("SDET");
		
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		System.out.println(json);
	    RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).when().body(json);
		Response response = request.post();


	}
	
	// JSON -> POJO
	@Test
	public void testDeserilization() throws JsonProcessingException {
		String data = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		ObjectMapper obj = new ObjectMapper();
		Pojo obj1 = obj.readValue(data, Pojo.class);
		 RestAssured.baseURI = "https://reqres.in/api/users";
			RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).when().body(obj1);
			Response response = request.post();
		    response.then().log().all();
	}
}
