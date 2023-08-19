package com.testng.base;

import java.io.File;   
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.api.base.Base;
import com.utils.DataInputProvider;


public class ProjectSpecificMathod extends Base{
	
	public String dataFileName, dataFileType;
	public static String sysID;
	//Reporting
	@BeforeSuite
	public void beforeSuite() {
		startReport();	// set report path	
	}
	//Reporting - > creating entry for each testcases
	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);		
	}
	
	
	@BeforeMethod
	public void beforeMethod()  {
		//for reports		
		svcTest = startTestModule(nodes);
		svcTest.assignAuthor(authors);
		svcTest.assignCategory(category);
		
		
	

	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterSuite
	public void afterSuite() {
		// report output
		endResult();
	}

	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		if(dataFileType.equalsIgnoreCase("Excel"))
			return DataInputProvider.getSheet(dataFileName);	
		else if(dataFileType.equalsIgnoreCase("JSON")){
			Object[][] data = new Object[1][1];
			data[0][0] = new File("./data/"+dataFileName+"."+dataFileType);
			System.out.println(data[0][0]);
			return data;
		}else {
			return null;
		}
			
	}

	public long takeSnap() {
		return 0;
	}	

	
	
}

