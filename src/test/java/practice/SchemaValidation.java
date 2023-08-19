package practice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SchemaValidation {
	
	@Test
	public void schema() {
		RestAssured.baseURI = "https://reqres.in/api/unknown";
	    RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
	    Response response = request.get();
	    response.then().log().all();
	    
	    File file = new File("./src/test/resources/SchemaValidation.json");
	    
	    response.then().body(JsonSchemaValidator.matchesJsonSchema(file));

	}

}
