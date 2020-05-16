package com.APIFramework.APITestCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import com.APIFramework.Assertions.ResponseAssertions;
import com.APIFramework.CustomUtilities.HTTPRequest;
import com.APIFramework.CustomUtilities.PropertiestFile;
import com.APIFramework.CustomUtilities.RequestBuilder;
import com.APIFramework.CustomUtilities.log4jutility;
import io.restassured.response.Response;

public class HTTPMethod_POST extends log4jutility {
	
	JSONObject json;
	
	//{"name":"test","salary":"123","age":"23"}
	
	@BeforeMethod
	public void postrequestbuilder() throws IOException {
		json = new JSONObject();
		json.put("name", "Sumanth");
		json.put("salary", RequestBuilder.randomId(3));
		json.put("age", RequestBuilder.randomId(2));
		//logger.info(json);
		
	}

	@Test
	public void postEmployeeData() throws IOException {
		logger.info("postEmployeeData Execution Started ");
		Properties getProperties = PropertiestFile.getPropertyFile();
		HTTPRequest httprequest_post = new HTTPRequest(getProperties);
		Response getResponse = httprequest_post.postRequest(json.toString(),getProperties.getProperty("baseURL"),getProperties.getProperty("postPath"));

		ResponseAssertions.responseBodyNullCheck(getResponse);
		ResponseAssertions.responseStatusCodeValidation(getResponse);
		ResponseAssertions.responseStatusLineValidation(getResponse);
		String stat = ResponseAssertions.responseParamsValidation(getResponse, "status"); // To pull the response from the jpath value
		logger.info(stat);
		Assert.assertEquals(getResponse.jsonPath().getString("data.name"),"Sumanth"); // To assert the jpath value
		logger.info("Request Data :: "+(getProperties.getProperty("baseURL")+getProperties.getProperty("postPath")));
		logger.info("Response Data :: "+getResponse.asString());
		
	}
}
