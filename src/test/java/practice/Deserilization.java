package practice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deserilization {
	
	@Test
	public void converJson2Java() throws JsonMappingException, JsonProcessingException {
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		String data = "{\r\n"
				+ "  \"name\" : \"Gangadaran\",\r\n"
				+ "  \"job\" : \"SDET\",\r\n"
				+ "  \"empID\" : 4324,\r\n"
				+ "  \"title\" : \"QA\"\r\n"
				+ "}";
		
		ObjectMapper obj = new ObjectMapper(); 
		Pojo readValue = obj.readValue(data, Pojo.class);
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).body(readValue);
		Response response = request.post();
		response.prettyPrint();

	}

}
