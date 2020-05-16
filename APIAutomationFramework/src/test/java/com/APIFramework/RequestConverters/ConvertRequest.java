package com.APIFramework.RequestConverters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.XML;

public class ConvertRequest {

	public static JSONObject createJsonRequest(String fileURL) throws FileNotFoundException {
		FileReader readfile = new FileReader(fileURL); // Read the JSON String from the file path
		JSONTokener parseFileToJSON = new JSONTokener(readfile);// parse the string data in to json format to be able to
																// read the Json Keys

		JSONObject convertToJSONObject = new JSONObject(parseFileToJSON);// convert to the json object.
		return convertToJSONObject; // return the JSON Object Converted String data
	}

	public static String convertJSON_to_XML(String fileURL) throws IOException {
		FileReader readFile = new FileReader(fileURL);
		JSONTokener parseFile = new JSONTokener(readFile);
		JSONObject storeObj = new JSONObject(parseFile);
		String xmlConvert = XML.toString(storeObj);
		return xmlConvert;

	}

	public static JSONObject covertXML_to_JSON(String fileURL) throws IOException {
		FileReader readFile = new FileReader(fileURL);
		BufferedReader getFileData = new BufferedReader(readFile);
		String store;
		String increaseData = null;
		while ((store = getFileData.readLine()) != null) {
			increaseData += store;
		}
		JSONObject convertedJSOn = XML.toJSONObject(increaseData);
		getFileData.close();
		return convertedJSOn;
	}

}
