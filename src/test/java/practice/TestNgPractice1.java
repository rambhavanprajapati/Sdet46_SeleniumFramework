package practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tyss.genericUtility.configuration.BaseClassPractice;
import com.tyss.genericUtility.constants.IConstantsUtility;
import com.tyss.genericUtility.enums.ExcelSheet;
import com.tyss.genericUtility.enums.PropertyKey;
import com.tyss.genericUtility.externalFileUtility.ExcelFileUtility;
import com.tyss.genericUtility.externalFileUtility.PropertyFileUtility;
import com.tyss.genericUtility.misc.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(com.tyss.genericUtility.retry.SetTestParameter.class)
public class TestNgPractice1 extends BaseClassPractice {
	
	@Test
	public void test()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.google.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test");
	}
	
	@Test
	public void test2()
	{
		
		System.out.println(Thread.currentThread().getId());
		driver.get("https://www.flipkart.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(false);
		System.out.println("Test2");
	}
	
	@Test
	public void test3()
	{
		System.out.println(Thread.currentThread().getId());
		driver.get("http://localhost:8888/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test3");
	}
}
