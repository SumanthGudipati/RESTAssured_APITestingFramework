package com.APIFramework.APITestCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import com.APIFramework.Assertions.ResponseAssertions;
import com.APIFramework.CustomUtilities.HTTPRequest;
import com.APIFramework.CustomUtilities.PropertiestFile;
import com.APIFramework.CustomUtilities.RequestBuilder;
import com.APIFramework.CustomUtilities.log4jutility;
import io.restassured.response.Response;

public class HTTPMethod_DELETE extends log4jutility {

	JSONObject json = new JSONObject().put("value", RequestBuilder.randomId(2));

	@Test
	public void deleteEmployeeData() throws IOException {
		logger.info("deleteEmployeeData Execution Started ");
		Properties getProperties = PropertiestFile.getPropertyFile();
		HTTPRequest httprequest_put = new HTTPRequest(getProperties);
		Response getResponse = httprequest_put.deleteRequest(getProperties.getProperty("baseURL"),
				getProperties.getProperty("deletepath"), json.getString("value"));
		ResponseAssertions.responseBodyNullCheck(getResponse);
		ResponseAssertions.responseStatusCodeValidation(getResponse);
		ResponseAssertions.responseStatusLineValidation(getResponse);
		Assert.assertEquals(getResponse.jsonPath().getString("status"), "success");

		logger.info(getProperties.getProperty("baseURL") + getProperties.getProperty("deletepath")
				+ json.getString("value"));
		logger.info("Response Data :: " + getResponse.asString());

	}
}
