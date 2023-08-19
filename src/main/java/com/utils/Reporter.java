package com.utils;

import java.io.File; 
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.restassured.RestAssured;

public abstract class Reporter {
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public static ExtentTest svcTest;
	public ExtentTest testSuite, test;
	public String testCaseName, testDescription, nodes, authors,category;
	
	public void startReport() {
		
	
		html = new ExtentHtmlReporter("./alert/result.html");
		html.setAppendExisting(true);// include all result
		extent = new ExtentReports();
		extent.attachReporter(html);		
	}

	// Every @Test
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		testSuite = extent.createTest(testCaseName, testDescription);		
		return testSuite;
	}

	// every test data
	public ExtentTest startTestModule(String nodes) {
		test = testSuite.createNode(nodes);
		return test;
	}
// write the report
	public void endResult() {
		extent.flush();
	}

	public abstract long takeSnap();

	
	

	//To log Rest Steps
	public static void reportRequest(String desc, String status) {
		
		MediaEntityModelProvider img = null;
		if(status.equalsIgnoreCase("PASS")) {
			svcTest.pass(desc, img);		
		}else if(status.equalsIgnoreCase("FAIL")) {
			svcTest.fail(desc, img);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("WARNING")) {
			svcTest.warning(desc, img);		
		}else {
			svcTest.info(desc);
		}	
	}

}
