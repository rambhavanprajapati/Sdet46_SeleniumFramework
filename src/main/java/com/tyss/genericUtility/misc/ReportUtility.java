package com.tyss.genericUtility.misc;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tyss.genericUtility.constants.IConstantsUtility;
import com.tyss.genericUtility.enums.PropertyKey;
import com.tyss.genericUtility.externalFileUtility.PropertyFileUtility;

/**
 * This class contains generic methods of extent reports
 * @author Zero Touch
 *
 */
public class ReportUtility {

	private ExtentReports report;
	String extentReportPath;
	/**
	 * This constructor is used to initialize the path of report  
	 * @param filePath
	 * @param title
	 * @param reportName
	 * @param browserName
	 */
	public ReportUtility() {
		PropertyFileUtility pUtil = new PropertyFileUtility(IConstantsUtility.REPORT_PROPERTY_FILE_PATH);
		String overrideOrNot = pUtil.getPropertyData(PropertyKey.OVERRIDE_REPORT);
		String randomName="";
		if(overrideOrNot.equalsIgnoreCase("no"))
		{
			randomName="_"+new JavaUtility().getCurrentStringDate();
		}
		extentReportPath = IConstantsUtility.EXTENT_REPORT_FOLDER_PATH+"extentReport"+randomName+".html";
		ExtentSparkReporter spark = new ExtentSparkReporter(extentReportPath);
		spark.config().setDocumentTitle(pUtil.getPropertyData(PropertyKey.EXTENT_REPORT_TITLE));
		spark.config().setReportName(pUtil.getPropertyData(PropertyKey.EXTENT_REPORT_NAME));
		spark.config().setTheme(Theme.DARK);

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", pUtil.getPropertyData(PropertyKey.BROWSER));
		report.setSystemInfo("OS", System.getProperty("os.name"));
	}

	/**
	 * This method is used to create the test name
	 * @param testName
	 */
	public void createTest(String testName)
	{
		ExtentTest test = report.createTest(testName);
		UtilityInstanceTransfer.setExtentTest(test);
	}

	/**
	 * This method is used to give report of failed script
	 * @param message
	 */
	public void fail(ExtentTest test, String message, Throwable errorMsg)
	{
		test.fail(message);
		test.fail(errorMsg);
		System.out.println(message);
	}

	/**
	 * This method is used to add the author name
	 * @param names
	 */
	public void addAuthor(ExtentTest test, String... names)
	{
		test.assignAuthor(names);
	}

	/**
	 * This method is used to add the category of script
	 * @param names
	 */
	public void addCategory(ExtentTest test, String...names)
	{
		test.assignCategory(names);
	}

	/**
	 * This method is used to give exception of skipped script
	 * @param errorMessage
	 */
	public void skip(ExtentTest test, String message, Throwable errorMessage)
	{
		test.skip(message);
		test.skip(errorMessage);
		System.out.println(message);
	}

	/**
	 * This method is used to give result of pass script
	 * @param message
	 */
	public void pass(ExtentTest test, String message)
	{
		test.pass(message);
	}

	/**
	 * This method is used to give message for warning
	 * @param message
	 */
	public void warn(ExtentTest test, String message)
	{
		test.warning(message);
	}

	/**
	 * This method will give information of script
	 * @param message
	 */
	public void info(ExtentTest test, String message)
	{
		test.info(message);
		System.out.println(message);
	}

	/**
	 * This method is used to attach the screenshot file with report
	 * @param screenShotPath
	 * @param title
	 * @param strategy
	 */
	public void attachScreenShot(ExtentTest test, String screenShotPath, String title, String strategy)
	{
		if(strategy.equalsIgnoreCase("base64"))
		{
			test.addScreenCaptureFromBase64String(screenShotPath, title);
		}
		else
		{
			test.addScreenCaptureFromPath(screenShotPath, title);
		}
	}

	/**
	 * This method is used to save the report
	 */
	public void saveReport()
	{
		report.flush();
		try {
			Desktop.getDesktop().browse(new File(extentReportPath).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
