package RePractice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SchemaValidation {
	@Test
	public void testSchemaValition() {
		
		File file = new File("./src/test/resources/SchemaValidation.json");
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON);
	    Response response = request.get();
	    response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
	    

	}
}
