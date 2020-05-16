package com.APIFramework.APITestCases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import com.APIFramework.Assertions.ResponseAssertions;
import com.APIFramework.CustomUtilities.HTTPRequest;
import com.APIFramework.CustomUtilities.PropertiestFile;
import com.APIFramework.CustomUtilities.log4jutility;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;

public class HTTPMethod_GET extends log4jutility {

	public ExtentTest test;
	@Test
	public void getEmployeeData() throws IOException {
		logger.info("getEmployeeData Execution Started ");
		Properties getProperties = PropertiestFile.getPropertyFile();
		HTTPRequest httprequest_get = new HTTPRequest(getProperties);
		Response getResponse = httprequest_get.getRequest(getProperties.getProperty("baseURL"), getProperties.getProperty("getroute"));
		ResponseAssertions.responseBodyNullCheck(getResponse);
		ResponseAssertions.responseStatusCodeValidation(getResponse);
		ResponseAssertions.responseStatusLineValidation(getResponse);
		logger.info("Request Data :: "+ (getProperties.getProperty("baseURL")+getProperties.getProperty("getroute")));
		logger.info("Response Data :: "+getResponse.asString());


		
	}
}
