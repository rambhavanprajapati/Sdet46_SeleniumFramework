package com.tyss.genericUtility.WebActions;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains generic methods of popups
 * @author Zero Touch
 *
 */
public class PopupsUtility {
	
	/**
	 * This method used to accept the alert popup
	 * @param driver
	 */
	public void confirmAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method used to dismiss the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method used to send the data into the alert popup
	 * @param driver
	 * @param value
	 * @return 
	 */
	public void setDataAlert(WebDriver driver, String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	/**
	 * This method used to fetch the value of alert popup
	 * @param driver
	 * @return
	 */
	public String getDataAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame based on name or id
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch to frame based on web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}

	public void Calendar(WebElement currentMonthYear, WebElement next, WebElement previous, String reqMonth, String reqYear)
	{
		int reqMonthNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
		int reqYearNum = Integer.parseInt(reqYear);
		String curMonthYear = currentMonthYear.getText();
		int curMonthNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
		int curYearNum = Integer.parseInt(curMonthYear.split(" ")[1]);
		while(reqMonthNum>curMonthNum || reqYearNum>curYearNum)
		{
			next.click();
			curMonthYear = currentMonthYear.getText();
			curMonthNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
			curYearNum = Integer.parseInt(curMonthYear.split(" ")[1]);
		}
		
		while(reqMonthNum<curMonthNum || reqYearNum<curYearNum)
		{
			previous.click();
			curMonthYear = currentMonthYear.getText();
			curMonthNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
			curYearNum = Integer.parseInt(curMonthYear.split(" ")[1]);
		}
	}
}
