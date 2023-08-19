package practice;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Serilization {
	
	@Test
	public void convertPojo2Json() throws JsonProcessingException {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		Pojo po = new Pojo();
		po.setEmpID(4324);
		po.setJob("SDET");
		po.setName("Gangadaran");
		po.setTitle("QA");
		
		
		
		// convert Java object to Json object (Serilization)
		
		ObjectMapper obj = new ObjectMapper();
		String jsonData = obj.writerWithDefaultPrettyPrinter().writeValueAsString(po);
		
		 System.out.println(jsonData);
		
		
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).body(jsonData);
		Response response = request.post();
		
		

	}

}
