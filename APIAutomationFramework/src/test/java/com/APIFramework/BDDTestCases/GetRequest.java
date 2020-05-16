package com.APIFramework.BDDTestCases;

import org.testng.annotations.Test;

import com.APIFramework.CustomUtilities.PropertiestFile;
import com.APIFramework.CustomUtilities.log4jutility;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.testng.Reporter;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.*;

public class GetRequest extends log4jutility {

	@Test
	public void getRequest() throws IOException {
		Properties properties = PropertiestFile.getPropertyFile();
		//logger.info(properties.getProperty("getweather"));
		ValidatableResponse response = given().when().get(properties.getProperty("getweather")).then().statusCode(200)
				.statusLine("HTTP/1.1 200 OK").assertThat().body("City", equalTo("Hyderabad"))
				.header("Content-Type", "application/json");

		ExtractableResponse<Response> extractableResponse = response.extract();
		//logger.info(extractableResponse.asString());

		extractableResponse.jsonPath().get("City").equals("Hyderabad");

		Reporter.log("Request log :: " + properties.getProperty("getweather"));
		Reporter.log("Response log :: " + extractableResponse.asString());

	}

}
