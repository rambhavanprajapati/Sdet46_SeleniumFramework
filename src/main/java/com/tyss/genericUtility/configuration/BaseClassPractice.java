package com.tyss.genericUtility.configuration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tyss.genericUtility.WebActions.WebDriverUtility;
import com.tyss.genericUtility.misc.JavaUtility;

public class BaseClassPractice {
	
	public WebDriverUtility wUtil;
	public JavaUtility jUtil;
	public WebDriver driver;
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("FirstCommit");
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public void btConfig()
	{
		System.out.println("BeforeTest");
		
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("BeforeClass");
		wUtil = new WebDriverUtility();
		jUtil = new JavaUtility();
		driver=wUtil.launchBrowser("chrome","");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("BeforeMethod");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("AfterSuite");
	}
	
	@AfterTest
	public void atConfig()
	{
		System.out.println("AfterTest");
		
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("AfterClass");
		driver.close();
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("AfterMethod");
	}


}
