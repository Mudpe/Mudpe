package com.Listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class HTMLReport2 implements  ITestListener{
	
	    private ExtentReports extentReports;
	    private ExtentSparkReporter extentSparkReporter;
	    private ExtentTest extentTest;

	    @Override
	    public void onStart(ITestContext context) {
	        extentSparkReporter = new ExtentSparkReporter("C:\\Users\\abhil\\OneDrive\\Desktop"+ "/report.html");
	        extentSparkReporter.config().setDocumentTitle("Automation Report");
	        extentSparkReporter.config().setReportName("Test Execution Results");

	        extentReports = new ExtentReports();
	        extentReports.attachReporter(extentSparkReporter);
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        extentTest = extentReports.createTest(result.getMethod().getMethodName());
	    }
	    
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        extentTest.pass("Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        extentTest.fail(result.getThrowable()); // logs exception details
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        extentTest.skip("Test skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extentReports.flush(); // writes report.html
	    }


}
