package com.APIFramework.CustomUtilities;

import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/AutomationReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");// title of report
		htmlReporter.config().setReportName("API Automation Framework - RESTASSURED");// name of report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Execution Server", "localhost");
		extent.setSystemInfo("Execution Environment", "QA");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());// create new entry in the report
		test.log(Status.PASS, "Execution Passed for :: " + result.getName());
		List<String> reporterMessages = Reporter.getOutput(result);
		//System.out.println("reporterMessages" + reporterMessages);
		for (int i = 0; i < reporterMessages.size(); i++) {
			System.out.println(reporterMessages.get(i));

			test.info(reporterMessages.get(i));
		}

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());// create new entry in the report
		test.log(Status.FAIL, "Execution Failed for :: " + result.getName());
		test.log(Status.FAIL, "Execution Failed with :: " + result.getThrowable());
		List<String> reporterMessages = Reporter.getOutput(result);
		// System.out.println("reporterMessages" + reporterMessages);
		for (int i = 0; i < reporterMessages.size(); i++) {
			System.out.println(reporterMessages.get(i));

			test.info(reporterMessages.get(i)); // To Print Request and Response to Report
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());// create new entry in the report
		test.log(Status.SKIP, "Execution Skipped for :: " + result.getName());
	}

	public void onFinish(ITestContext testcontext) {
		extent.flush();
	}
}
