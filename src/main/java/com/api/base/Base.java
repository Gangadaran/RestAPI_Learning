package com.api.base;

import java.io.File; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONObject;

import com.api.design.Request;
import com.utils.Reporter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Base extends Reporter  implements Request  {

	@Override
	public  RequestSpecification setLogs() {
		Properties prob = new Properties();
		RequestSpecification log = null;
		try {
			prob.load(new FileInputStream("src/main/resources/configuration.properties"));
			log =RestAssured
			.given()
			.auth()
			.basic(prob.getProperty("username"), prob.getProperty("password"))
			.log().all().contentType(ContentType.JSON);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return log;
	}

	@Override
	public  Response get(String URL) {
		
		return setLogs()
				.get(URL);
	}

	@Override
	public   Response get() {
		
		return setLogs()
				.get();
	}

	@Override
	public  Response getWithHeaders(Map<String, String> headers, String URL) {
		 
		return setLogs()
				.when()
				.headers(headers)
				.get(URL);
	}

	@Override
	public  Response getWithHeader(Header header, String URL) {
		
		return setLogs()
				.when()
				.header(header)
				.get(URL);
	}

	@Override
	public  Response post() {
		
		return setLogs()
				.post();
	}

	@Override
	public  Response post(String URL, ContentType type) {
		
		return setLogs()
				.contentType(type)
				.post(URL);
	}

	@Override
	public  Response postWithBodyAsFile(File bodyFile) {
		
		return setLogs()
				.when()
				.body(bodyFile)
				.post();
	}

	@Override
	public  Response postWithBodyAsFileAndUrl(File bodyFile, String URL) {
		
		return setLogs()
				.body(bodyFile)
				.post(URL);
	}

	
	
	
	@Override
	public  Response postWithHeaderWithJsonObject(Map<String, String> headers, JSONObject jsonObject, String URL) {
		
		return setLogs()
				.headers(headers)
				.body(jsonObject)
				.post(URL);
	}

	@Override
	public  Response postWithJsonAsBody(String jsonObject, String URL) {
		
		return setLogs()
				.body(jsonObject)
				.post(URL);
	}

	@Override
	public  Response postWithHeaderAndJsonBody(Map<String, String> headers, String jsonObject, String URL) {
		
		return setLogs()
				.when()
				.headers(headers)
				.body(jsonObject)
				.post(URL);
	}

	@Override
	public  Response postWithHeaderParam(Map<String, String> headers, String URL) {
		
		return setLogs()
				.when()
				.headers(headers)
				.post(URL);
	}

	@Override
	public  Response postWithHeaderAndPathParam(Map<String, String> headers, Map<String, String> pathParms, String URL) {
		
		return setLogs()
				.when()
				.headers(headers)
				.pathParams(pathParms)
				.post(URL);
	}

	@Override
	public  Response postWithHeaderAndPathParam(Map<String, String> pathParms, String URL) {
		           
		return setLogs()
				.when()
				.pathParams(pathParms)
				.post(URL);
	}

	@Override
	public  Response delete(String URL) {
		
		return setLogs()
				.when()
				.delete(URL);
	}

	@Override
	public  Response deleteWithHeaderAndPathParam(Map<String, String> headers, JSONObject jsonObject, String URL) {
	
		return setLogs()
				.when()
				.headers(headers)
				.body(jsonObject)
				.delete(URL);
	}

	@Override
	public  Response deleteWithHeaderAndPathParamWithoutRequestBody(Map<String, String> headers, String URL) {
		
		return setLogs()
				.when()
				.headers(headers)
				.delete(URL);
	}

	@Override
	public  Response putWithHeaderAndBodyParam(Map<String, String> headers, JSONObject jsonObject, String URL) {
		
		return setLogs()
				.when()
				.headers(headers)
				.body(jsonObject)
				.put(URL);
	}

	@Override
	public  Response putWithBodyParam(File file, String URL) {
		
		return setLogs()
				.body(file)
				.put(URL);
	}

	@Override
	public  ValidatableResponse enableResponseLog(Response response) {
	
		return response.then().log().all();
	}

	@Override
	public  ContentType getContentType() {
		
		return ContentType.JSON ;
	}

	@Override
	public  void verifyContentType(Response response, String type) {
		if (response.getContentType().toLowerCase().contains(type.toLowerCase())) {
			
		}else {
			
		}
		
	}

	@Override
	public  void verifyResponseCode(Response response, int code) {
		if (response.getStatusCode()==code) {
			
		} else {

		}
		
	}

	@Override
	public  void verifyResponseTime(Response response, long time) {
		if (response.getTime() <= time) {
			
		} else {

		}
		
	}

	@Override
	public  void verifyContentWithKey(Response response, String key, String expVal) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			String actValue = jsonPath.get(key);
			if (actValue.equalsIgnoreCase(expVal)) {
				
			}else {
				
			}
			
		} 
		
	}

	@Override
	public  void verifyContentsWithKey(Response response, String key, String expVal) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			List<String> actValue = jsonPath.getList(key);
			if (actValue.get(0).equalsIgnoreCase(expVal)) {
				
			}else {
				
			}
		}
		
	}

	@Override
	public  List<String> getContentsWithKey(Response response, String key) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return jsonPath.getList(key);
		}else {
			return null;
		}
		
	}

	@Override
	public  String getContentWithKey(Response response, String key) {
		if (response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return (String) jsonPath.get(key);
		}else {
			return null;
		}
		
	}

	
	public long takeSnap() {
		
		return 0;
	}

}
