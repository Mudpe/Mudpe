package com.Listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class HTMLReport implements  ITestListener{
	private ExtentSparkReporter extentSparkReporter;
	private ExtentTest extentTest;
	private ExtentReports extentReports;
//	private static ThreadLocal<ExtentTest> threadLocal;

	
	@Override
	public void onStart(ITestContext context) {
//		threadLocal = new ThreadLocal<>();
		extentReports = new ExtentReports();
		extentSparkReporter = new ExtentSparkReporter("report.html");
	//	extentSparkReporter.config().setDocumentTitle("Automation Report");
	//	extentSparkReporter.config().setReportName("Test Execution Results");
	
		extentReports.attachReporter(extentSparkReporter);
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
		//	threadLocal.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.fail("Test Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.skip("Test Skip");
	}



	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		
	
	}
	
	
	
}
