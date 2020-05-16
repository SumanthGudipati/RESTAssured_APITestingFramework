package com.APIFramework.CustomUtilities;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;


public class log4jutility {
	
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("API Testing Framework - RestAssured");
		PropertyConfigurator.configure("log4j.properties");//configuring log4j properties file
		logger.setLevel(Level.DEBUG); // Configure loglevel properties DEBUG.INFO
	}

}
