package tms.movingBird.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tms.movingBird.elementRepository.enums.LinkNames;

public class PackageDetailsPage {
	
	//declaration
	private WebDriver driver;
	private String selectDatePartialLocator = "%s";
	private String datePartialLinkText = "%s";
	@FindBy(name = "comment") private WebElement commentTxtField;
	@FindBy(xpath = "//button[text()='Book']") private WebElement bookBtn;
	
	/**
	 * This method is used to convert partial locator String into WebElement
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElementOfid(String partialLocator, String replaceData)
	{
		String Locator = String.format(partialLocator, replaceData);
		return driver.findElement(By.id(Locator));
	} 

	/**
	 * This method is used to convert partial locator String into WebElement
	 * @param partialLinkText
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElementOfLinkText(String partialLinkText, String replaceData)
	{
		String linkText = String.format(partialLinkText, replaceData);
		return driver.findElement(By.linkText(linkText));
	}
	
	/**
	 * initialization
	 * @param driver
	 */
	public PackageDetailsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform click action on a particular module of calendar
	 * @param linkName
	 */
	public void clickOnDateField(LinkNames linkName)
	{
		convertToWebElementOfid(selectDatePartialLocator, linkName.getLink()).click();
	}
	
	/**
	 * This method is used to perform click action on a particular date
	 * @param date
	 */
	public void clickOnDate(String date)
	{
		convertToWebElementOfLinkText(datePartialLinkText, date).click();
	}
	
	/**
	 * This method is used to send the data into comment text field
	 * @param value
	 */
	public void commentTxtField(String value)
	{
		commentTxtField.sendKeys(value);
	}
	
	/**
	 * This method is used to click on book button 
	 */
	public void bookBtnAction()
	{
		bookBtn.click();
	}
}
