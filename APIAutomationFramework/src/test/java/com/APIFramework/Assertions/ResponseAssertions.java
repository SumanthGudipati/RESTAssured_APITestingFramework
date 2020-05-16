package com.APIFramework.Assertions;

import org.testng.Assert;

import com.APIFramework.CustomUtilities.log4jutility;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.response.Response;

public class ResponseAssertions extends log4jutility {
	

	// To validate the response Status code returned by the server
	public static void responseStatusCodeValidation(Response response) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		logger.info("responseStatusCodeValidation Method execcuted Successfully ::: " + statusCode);

	}
	
	// To validate the response Status code returned by the server
	public static String responseParamsValidation(Response response , String jpath) {
		logger.info("responseParamsValidation Method execcuted Successfully Jpath ::: " +jpath +" and result is ::: " + response.jsonPath().get(jpath));
		return response.jsonPath().get(jpath);
	}

	// To validate the response Status line returned by the server
	public static void responseStatusLineValidation(Response response) {
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		logger.info("responseStatusLineValidation Method execcuted Successfully ::: " + statusline);

	}

	// To compare the integer value
	public static void responseIdValidation(int actualStatusid, int expectedStatusid) {

		if (actualStatusid == expectedStatusid) {
			System.out.println("Test Assertion is Sucessful Matching Actual Result :: " + actualStatusid
					+ " with Expected Result :: " + expectedStatusid);
		} else {
			System.out.println("Test Assertion is Sucessful not Matching Actual Result :: " + actualStatusid
					+ " with Expected Result :: " + expectedStatusid);
		}
	}

	// To compare the String value
	public static void responseStringValidation(String actualStatusMessage, String expectedStatusMessage) {

		if (actualStatusMessage == expectedStatusMessage) {
			System.out.println("Test Assertion is Sucessful Matching Actual Result :: " + actualStatusMessage
					+ " with Expected Result :: " + expectedStatusMessage);
		} else {
			System.out.println("Test Assertion is Sucessful not Matching Actual Result :: " + actualStatusMessage
					+ " with Expected Result :: " + expectedStatusMessage);
		}
	}

	// To validate the response returned by the server is less than 10 sec
	public static void responseTimeCheckValidation(Response response) {
		long responsetime = response.getTime();
		if (responsetime > 2000) {
			logger.warn("response time is greater than 2000");
		}
		Assert.assertTrue(responsetime < 10000);
		logger.info("Total Time taken from the server to return the response is :: " + responsetime);

	}

	// To validate the Cookie returned by Server is correct
	public static void responseCookieValidation(Response response) {
		String cookie = response.cookie("");
		logger.info("Cookie Validation is Sucessful :: " + cookie);
	}

	// To validate the response returned by the Server is not null
	public static void responseBodyNullCheck(Response response) {
		String responseBody = response.getBody().asString();
		logger.info("Response returned by the server ==>" + responseBody);
		Assert.assertTrue(responseBody != null);

	}
}
