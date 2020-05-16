package com.APIFramework.CustomUtilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RequestBuilder {
	
	public static String randomString(int value) {
		String randomstring = RandomStringUtils.randomAlphabetic(value);
		return (randomstring);
	}
	public static String randomId(int value) {
		String randomid = RandomStringUtils.randomNumeric(value);
		return randomid;
	}

	public static String email() {
		String randomid = RandomStringUtils.randomNumeric(3);
		String email = "Username"+randomid+"@gmail.com";
		return email;
	}
}
