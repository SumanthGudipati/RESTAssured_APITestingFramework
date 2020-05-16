package com.APIFramework.CustomUtilities;

import static io.restassured.RestAssured.given;

import java.util.Properties;

import org.json.JSONObject;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPRequest {

	// Properties variable to assign the properties file value.
	Properties pr;
	
	// Creating constructor for pass the properties values.
	public HTTPRequest(Properties pr) {

		this.pr = pr;
	}

	// To publish the post Request to the server -- POST Method
	public Response postRequest(String request, String baseURL,String path) // Post method for create record. Method
																			// required 3 parameters
	{
		Response postRequestResponse = // Response object to store the server response
				RestAssured.given().contentType(ContentType.JSON) // Assign the ContentType that will be accepted by the Server.
						.body(request) // pass the expected data
						.post(baseURL+path); // URL and Route of the of API
		
		// To log the Request and Response to Report
		Reporter.log("Request log :: " +request);
		Reporter.log("Response log :: " +postRequestResponse.getBody().asString());
																					
		return postRequestResponse;

	}

	// To pull the Response from the server using --- GET Method
	public Response getRequest(String host, String path) {

		Response getRequestResponse = // Response object to store the server response

				RestAssured.given().contentType(ContentType.JSON) // Assign the ContentType that will be accepted by the Server.
						.when().get(host+path);
		Reporter.log("Request log :: " +(host+path));
		Reporter.log("Response log :: " +getRequestResponse.getBody().asString());

		return getRequestResponse;
	}

	public Response getRequestByID(String host, String path, String id) {

		Response getRequestResponse = // Response object to store the server response

				RestAssured.given().contentType(ContentType.JSON) // Assign the ContentType that will be accepted by the Server.
						.when().get(host+path+id);
		
		Reporter.log("Request log :: " +(host+path+id));
		Reporter.log("Response log :: " +getRequestResponse.getBody().asString());

		return getRequestResponse;
	}
	// To Update the resource on the server for the specific field/ID -- PUT Method
	public Response putRequest(String request, String host, String path, String expectedID) {

		Response putRequestRespose = RestAssured.given().contentType(ContentType.JSON).body(request).when()
				.put(host+path+expectedID);
		Reporter.log("Request log :: " +(host+path+expectedID));
		Reporter.log("Response log :: " +putRequestRespose.getBody().asString());
		return putRequestRespose;
	}

	// To delete the resource on the server for the given id -- DELETE Method
	public Response deleteRequest(String host, String path, String expectedID) {
		Response deleteRequestResponse = RestAssured.given().contentType(ContentType.JSON).when()
				.delete(host+path+expectedID);
		Reporter.log("Request log :: " +host+path+expectedID);
		Reporter.log("Response log :: " +deleteRequestResponse.getBody().asString());
		return deleteRequestResponse;
	}
}
