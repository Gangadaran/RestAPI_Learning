package com.api.testcase;

import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test;

import com.testng.base.ProjectSpecificMathod;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUsers extends ProjectSpecificMathod {
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "getUsers";
		testDescription = "The first testcase";
		nodes = "require";
		authors = "Gangadaran";
		category = "REST";
		//dataProvider
		dataFileName = "TC001";
		dataFileType = "JSON";
	}
	
	@Test
	public void exam() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		
		enableResponseLog(response);
		
		
		

	}
	
	
	   
	

}
