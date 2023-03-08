package com.tyss.genericUtility.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tyss.genericUtility.annotation.Report;
import com.tyss.genericUtility.configuration.ConfigClass;
import com.tyss.genericUtility.misc.ReportUtility;
import com.tyss.genericUtility.misc.UtilityInstanceTransfer;

/**
 * This class contains all the method present in ITestListener and ISuiteListener
 * @author Zero Touch
 *
 */
public class ExtentReportListener implements ITestListener, ISuiteListener {

	private ReportUtility report;
	public static ReportUtility sreport;
	
	/**
	 * This method will execute before the @BeforeSuite
	 * In this method we are initializing extent report path, title, name and browser
	 */
	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStart --> Suite");
		report = new ReportUtility();
		
		sreport=report;
		
	}

	/**
	 * This method will save the report
	 */
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onStart --> Suite");
		report.saveReport();
		
	}

	/**
	 * This method will execute before the execution of testScript
	 * In This method we are generating name of author and category and test name
	 */
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart -> Test");
		report.createTest(result.getMethod().getMethodName());
		Report reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Report.class);
		System.out.println(reportAnnotation.author());
		System.out.println(reportAnnotation.category());
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
		
	}

	/**
	 * This method will execute after the script will be successfully executed and give report with script name pass
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess -> Test");
		report.pass(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is pass");
	}

	/**
	 * This method will execute after the script will be failed and give report with script name is failed
	 * and also it will take the screenshot of the script
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure -> Test");
		report.fail(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is failed", result.getThrowable());
		
		String screenShotPath = null;
		
		screenShotPath = ConfigClass.class.cast(result.getMethod().getInstance()).wUtil.takeScreenShot();
		
		report.attachScreenShot(UtilityInstanceTransfer.getExtentTest(), screenShotPath, result.getMethod().getMethodName(), "base64");
		
	}

	/**
	 * This method will execute after the script will be skipped and give report with script name is skipped
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped -> Test");
		report.skip(UtilityInstanceTransfer.getExtentTest(), result.getMethod().getMethodName()+" is skipped", result.getThrowable());
	}

	/**
	 * 
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage -> Test");
	}

	/**
	 * 
	 */
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout -> Test");
	}

	/**
	 * This method will execute before the @BeforeTest
	 */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart -> Test");

	}

	/**
	 * This method will execute after the execution of script
	 */
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish -> Test");
	}
}
