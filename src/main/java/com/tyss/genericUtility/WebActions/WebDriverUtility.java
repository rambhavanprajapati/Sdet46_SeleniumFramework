package com.tyss.genericUtility.WebActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;

import com.tyss.genericUtility.misc.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains generic methods to perform all web driver related actions 
 * @author Zero Touch
 *
 */
public class WebDriverUtility {
	
	private WebDriver driver;
	
	/**
	 * This method is used to launch the particular browser
	 * @param browser
	 * @param s
	 * @return
	 */
	public WebDriver launchBrowser(String browser, @Optional String s)
	{
		switch(browser)
		{
		case "chrome":
			if(s!=null) {
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--disable-notification");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(opt);
				break;
			}
			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
		case "firefox":
			if(s!=null) {
				FirefoxOptions opt = new FirefoxOptions();
				opt.addArguments("--disable-notification");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
			else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Enter proper key");
			break;
		}
		return driver;
	}
	
	/**
	 * This method is used to launch the application 
	 * @param url
	 */
	public void launchApplication(String url)
	{
		driver.get(url);
	}
	
	/**
	 * This method will give full screen of window
	 * @param driver
	 */
	public void fullscreenWindow()
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * This method will fetch the title of the web page
	 * @param driver
	 * @return 
	 */
	public String getTitleOfWebPage()
	{
		return driver.getTitle();
	}
	 /**
	 * This method will maximize the window when its called
	 * @param driver
	 */
	public void maximiseWindow()
	{
		driver.manage().window().maximize();
	}

	/**
	  * This method will open the application of browser
	  * @param driver
	  * @param url
	  */
	public void getApplication(WebDriver driver, String url)
	{
		driver.get(url);
	}
	
	/**
	 * This method will fetch the current url of web page
	 * @param driver
	 * @return 
	 */
	public String getUrlOfWebpage(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	/**
	 * This method will fetch the source code of web page
	 * @param driver
	 * @return 
	 */
	public String getSourceCodeOfWebpage(WebDriver driver)
	{
		return driver.getPageSource();
	}
	
	/**
	 * This method will close only the main window
	 * @param driver
	 */
	public void closeMainWindow(WebDriver driver)
	{
		driver.close();
	}
	
	/**
	 * This method will close all the window
	 * @param driver
	 */
	public void closeAllWindow(WebDriver driver)
	{
		driver.quit();
	}
	
	/**
	 * This method will customize the width and height of browser
	 * @param driver
	 * @param width
	 * @param height
	 * @return 
	 */
	public void setSizeOfBrowser(WebDriver driver, int width, int height)
	{
		driver.manage().window().setSize(new Dimension(width, height));
	}
	
	/**
	 * This method will customize the x and y co-ordinate of browser
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void setPositionOfBrowser(WebDriver driver, int x, int y)
	{
		driver.manage().window().setPosition(new Point(x, y));
	}
	
	/**
	 * This method will remove the value present in web element
	 * @param element
	 */
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	
	/**
	 * This method will return tag name of web element
	 * @param element
	 * @return 
	 */
	public String getTagNameOfElement(WebElement element)
	{
		return element.getTagName();
	}
		
	/**
	 * This method will press and release the enter key
	 * @throws AWTException
	 */
	Robot r;
	public void pressEnterKey()
	{
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
		
	/**
	 * This method will take screenshot of web page and save it in screenshot folder
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(String screenShotName, JavaUtility jUtil)
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("./ScreenShot/"+screenShotName+"_"+jUtil.getCurrentStringDate()+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return trg.getAbsolutePath(); //used for extent reports
	}
	
	/**
	 * This method will take screenshot of web element and save it in screenshot folder
	 * @param element
	 * @param elementName
	 * @param jUtil
	 * @return
	 */
	public String takeScreenShot(WebElement element, String elementName, JavaUtility jUtil)
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		File trg = new File("./ScreenShot/elements"+elementName+"_"+jUtil.getCurrentStringDate()+".png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return trg.getAbsolutePath();
	}
	
	/**
	 * This method will take the screenshot using Base64
	 * @return
	 */
	public String takeScreenShot()
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
	}
	
	/**
	 * This method will switch to window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> allWindows=driver.getWindowHandles();
		for(String indWindow:allWindows)
		{
			String currentWinTitle = driver.switchTo().window(indWindow).getTitle();
				if(currentWinTitle.contains(partialWinTitle))
				{
					break;
				}
		}
	}
	
	/**
	 * This method will handle notifications popup
	 * @param driver
	 */
	public void notificationPopup(WebDriver driver)
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
	}
}
