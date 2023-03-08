package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPractice2 {

	@BeforeSuite
	public void bsConfig()
	{
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
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("AfterMethod");
	}
	@Test
	public void test()
	{
		System.out.println("Test");
	}
}
