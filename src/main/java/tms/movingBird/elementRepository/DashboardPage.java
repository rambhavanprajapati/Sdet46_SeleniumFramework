package tms.movingBird.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import tms.movingBird.elementRepository.enums.TabNames;

public class DashboardPage {

	private WebDriver driver;

	//declaration
	private String linkPartialXpath = "//span[.='%s']";

	/**
	 * This method is used to convert partial xpath String into WebElement
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialXpath, String replaceData)
	{
		String xpath = String.format(partialXpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * initialization
	 * @param driver
	 */
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to perform click action on a particular module of dashboard
	 * @param linkName
	 * @return 
	 */
	public void clickLink(TabNames tabName)
	{
		convertToWebElement(linkPartialXpath, tabName.getTab()).click();
	}

}
