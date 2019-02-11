package seleniumadvanced.demos.seleniumday1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{
	Logger LOGGER=LogManager.getLogger(MyListener.class);
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test start");
		LOGGER.info(result.getMethod().getMethodName()+"on test start");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test success");
		LOGGER.info(result.getMethod().getMethodName()+"on test success");
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test failure");
		LOGGER.info(result.getMethod().getMethodName()+"on test failure");
		LOGGER.info(result.getThrowable().getMessage());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test skipped");
		LOGGER.info(result.getMethod().getMethodName()+"on test skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test failed within success percentage");
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("on start");
		LOGGER.info("on start");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("on finish");
		LOGGER.info("on finish");
		
	}

}
