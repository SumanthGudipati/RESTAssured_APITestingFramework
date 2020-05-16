package com.APIFramework.APITestCases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import com.APIFramework.Assertions.ResponseAssertions;
import com.APIFramework.CustomUtilities.HTTPRequest;
import com.APIFramework.CustomUtilities.PropertiestFile;
import com.APIFramework.CustomUtilities.log4jutility;
import io.restassured.response.Response;

public class HTTPMethod_GET_IDData extends log4jutility {

	
	
	@Test
	public void getEmployeeDataByID() throws IOException {
		logger.info("getEmployeeData Execution Started ");
		Properties getProperties = PropertiestFile.getPropertyFile();
		HTTPRequest httprequest_get = new HTTPRequest(getProperties);
		Response getResponse = httprequest_get.getRequestByID(getProperties.getProperty("baseURL"), getProperties.getProperty("getIDPath"),"1");		
		ResponseAssertions.responseBodyNullCheck(getResponse);
		ResponseAssertions.responseStatusCodeValidation(getResponse);
		ResponseAssertions.responseStatusLineValidation(getResponse);
		logger.info(getProperties.getProperty("baseURL")+getProperties.getProperty("getIDPath")+"1");
		logger.info(" Response Data :: "+getResponse.asString());
	}
}
