package com.Listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReports implements ITestListener {

	private ExtentReports extentReports;
	private ExtentSparkReporter extentSparkReporter;
	private ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		extentSparkReporter = new ExtentSparkReporter("C:\\Users\\abhil\\Downloads\\"+"/Report"+com.utility.Selenium.gettime()+".html");
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
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			extentTest.addScreenCaptureFromPath(com.utility.Selenium.takeScreenshot(result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.fail("Test failure");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}


	

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}	
	
	
	

}
