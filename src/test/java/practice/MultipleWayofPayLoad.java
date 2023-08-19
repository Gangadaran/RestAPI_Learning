package practice;


import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MultipleWayofPayLoad {
	@Test
	public void payLoad() {
		// HashMap, JsonObject, File, Pojo
		JSONObject data = new JSONObject();
		data.put("name", "Ganga");
		data.put("job", "leader");
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(data.toString());
		Response response = request.post();
		
		response.prettyPrint();
		

	}

}
