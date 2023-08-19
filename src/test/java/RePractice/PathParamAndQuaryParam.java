package RePractice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PathParamAndQuaryParam {
	
	//https://reqres.in/api/users?page=2
	
	@Test
	public void QuaryParamAndPathParam() {
		RestAssured.given()
		.pathParam("myPath", "users")
		.queryParam("page", "2")
		.when()
		.get("https://reqres.in/api/{myPath}")
		.then()
		.statusCode(200)
		.body("data[0].email", Matchers.equalTo("michael.lawson@reqres.in")).log().all();
		
		

	}

}
