package com.tyss.genericUtility.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tyss.genericUtility.configuration.BaseClassPractice;
import com.tyss.genericUtility.misc.ReportUtility;
import com.tyss.genericUtility.misc.UtilityInstanceTransfer;

public class ExtentReportListenerPractice implements ITestListener {
 
	private ReportUtility report;
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart -> Test");
		report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess -> Test");
		report.pass(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure -> Test");
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+" is failed", result.getThrowable());
		String screenShotPath = null;
		
		screenShotPath = BaseClassPractice.class.cast(result.getMethod().getInstance()).wUtil.takeScreenShot();
		
		report.attachScreenShot(UtilityInstanceTransfer.getExtentTest(), screenShotPath, result.getMethod().getMethodName(), "base64");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped -> Test");
		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is skipped", result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage -> Test");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout -> Test");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart -> Test");
		report = new ReportUtility();
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish -> Test");
		report.saveReport();
	}
}
