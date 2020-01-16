package com.selenium.testCases;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener, ISuiteListener {
	
	public static Logger _LOGGER = Logger.getLogger(Listener.class);

	@Override
	public void onStart(ISuite suite) {
		System.out.println("\n              ******************************************************** Suite started - " + suite.getName() + " ********************************************************");
	}

	@Override
	public void onTestStart(ITestResult result) {
		_LOGGER.info("\n              ---------------------------------------------------- Test method started. ----------------------------------------------------\n              " + "Test Class Name : " + result.getTestClass().getName().replace("com.selenium.testCases.", "") + "\n              Test method name : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		_LOGGER.info("\n              Testcase method name : " + result.getName() + "\n              Test method Priority : " + result.getMethod().getPriority() + "\n              ---------------------------------------------------- Test method completed. ----------------------------------------------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		_LOGGER.error("\n              ---------------------------------------------------- Test method failed. ----------------------------------------------------\n              Failed Test Method Name : " + result.getName()  + "\n              Test method Priority : " + result.getMethod().getPriority());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		_LOGGER.info("\n              ---------------------------------------------------- Test method skipped. ----------------------------------------------------\n              Test method name : " + result.getName() + "\n              Test method Priority : " + result.getMethod().getPriority() );
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		_LOGGER.info("On start" + context.getOutputDirectory());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		_LOGGER.info("\n              Suite Name : " + context.getSuite().getName() + 
				"\n              Passed Tests : " + context.getPassedTests().getAllMethods().toString() + 
				"\n              Failed Tests : " + context.getFailedTests().getAllMethods().toString());
		
	}

	@Override
	public void onFinish(ISuite suite) {
		_LOGGER.info("\n              *****************************************************  Suite ended - " + suite.getName() + "  *****************************************************");
	}
	
	

}
