package com.api.design;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public interface Request {
	/*
	 * This method will 
	 */

	public RequestSpecification setLogs();

	public Response get(String URL);

	public  Response get();

	public  Response getWithHeaders(Map<String, String> headers, String URL);

	public  Response getWithHeader(Header header, String URL);

	public  Response post();

	public  Response post(String URL,ContentType type);

	public  Response postWithBodyAsFile(File bodyFile);

	public  Response postWithBodyAsFileAndUrl(File bodyFile, String URL);

	public  Response postWithHeaderWithJsonObject(Map<String, String> headers,
				JSONObject jsonObject, String URL);

	public  Response postWithJsonAsBody(String jsonObject, String URL);

	public  Response postWithHeaderAndJsonBody(Map<String, String> headers,
				String jsonObject, String URL);

	public  Response postWithHeaderParam(Map<String, String> headers, String URL);

	public  Response postWithHeaderAndPathParam(Map<String, String> headers,Map<String, String> pathParms, String URL);

	public  Response postWithHeaderAndPathParam(Map<String, String> pathParms, String URL);

	public  Response delete(String URL);

	public  Response deleteWithHeaderAndPathParam(Map<String, String> headers,
				JSONObject jsonObject, String URL);

	public  Response deleteWithHeaderAndPathParamWithoutRequestBody(
				Map<String, String> headers, String URL);

	public  Response putWithHeaderAndBodyParam(Map<String, String> headers,
				JSONObject jsonObject, String URL);

	public Response putWithBodyParam(File file, String URL);

	public ValidatableResponse enableResponseLog(Response response);

	public ContentType getContentType();

	public void verifyContentType(Response response, String type);

	public void verifyResponseCode(Response response, int code);

	public void verifyResponseTime(Response response, long time);

	public void verifyContentWithKey(Response response, String key, String expVal);

	public void verifyContentsWithKey(Response response, String key, String expVal);

	public List<String> getContentsWithKey(Response response, String key);

	public String getContentWithKey(Response response, String key);

}
