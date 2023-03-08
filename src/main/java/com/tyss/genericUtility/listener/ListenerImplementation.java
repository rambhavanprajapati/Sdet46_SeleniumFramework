package com.tyss.genericUtility.listener;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tyss.genericUtility.configuration.BaseClassPractice;

public class ListenerImplementation implements ITestListener, IClassListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart -> suite");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinish -> suite");
	}

	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass -> testClass");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass -> testClass");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart -> Test");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess -> Test");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure -> Test");
		
		BaseClassPractice.class.cast(result.getMethod().getInstance()).wUtil.takeScreenShot(result.getMethod().getMethodName(), BaseClassPractice.class.cast(result.getMethod().getInstance()).jUtil);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped -> Test");
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
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish -> Test");
	}
}
