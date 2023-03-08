package com.tyss.genericUtility.misc;

import com.aventstack.extentreports.ExtentTest;

/**
 * This class contains static getter and setter method of  ExtentTest
 * @author Zero Touch
 *
 */
public class UtilityInstanceTransfer {
	
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

	/**
	 * This method is used to get the ExtentTest instance
	 * @return
	 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * This method is used to set the ExtentTest instance
	 * @param setExtentTest
	 */
	public static void setExtentTest(ExtentTest setExtentTest) {
		extentTest.set(setExtentTest);
	}
	
	

}
