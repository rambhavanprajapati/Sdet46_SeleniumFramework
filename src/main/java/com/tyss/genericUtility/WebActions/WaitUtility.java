package com.tyss.genericUtility.WebActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods for wait
 * @author Zero Touch
 *
 */
public class WaitUtility {
	
	WebDriverWait wait;
	
	/**
	 * This method is used to initialize the instance of WebDriverWait
	 * @param driver
	 * @param timeunit
	 */
	public WaitUtility(WebDriver driver, long timeunit) {
		
		wait = new WebDriverWait(driver, timeunit);
	}
	
	/**
	 * This method will wait for entire page to load for required seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver, long timeunit)
	{
		driver.manage().timeouts().implicitlyWait(timeunit, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is use to wait for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebElement element)
	{
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	/**
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitElementToBeClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * This method will wait for element to be selected
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeSelected(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/**
	 * This method will wait for the text to be present in element
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void waitForTextToBePresentInElement(WebElement element, String text)
	{
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	/**
	 * 
	 * @param element
	 */
	public void waitForInvisible(WebElement element)
	{
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * This is a custom wait for a second to wait for elemnet to become clickable
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitForSecond(WebElement element) 
	{
		int count = 0;
		while(count<10)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count++;
			}
		}
	}
	
	/**
	 * This method is used to wait for given time 
	 * @param milisecond
	 */
	public void pause(long milisecond)
	{
		try {
			Thread.sleep(milisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
