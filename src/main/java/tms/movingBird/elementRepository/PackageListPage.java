package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.JavaScriptUtility;
import com.tyss.genericUtility.WebActions.WaitUtility;

public class PackageListPage {

	//declaration
	@FindBy(xpath = "//h4[text()='Package Name: UP trip']") private WebElement element;
	@FindBy(xpath = "//a[@href='package-details.php?pkgid=23']") private WebElement detailsBtn;
	@FindBy(xpath = "//div[@class='room-bottom']/div[last()]//h4") private WebElement element2;
	
	/**
	 * initialization
	 * @param driver
	 */
	public PackageListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to scroll till declared element
	 * @param j
	 */
	public void scrollTillElement(JavaScriptUtility j)
	{
		j.scrollTillElement(element);
	}
	
	/**
	 * This method is used to scroll down and wait till element visible
	 * @param w
	 * @param j
	 */
	public void waitForElement(WaitUtility w, JavaScriptUtility j)
	{
		j.scrollDown();
		w.waitForElementToBeVisible(element2);
	}
	
	/**
	 * This method is used to fetch the data of given element
	 * @return
	 */
	public String getTextOfElement()
	{
		return element2.getText();
	}
	
	/**
	 * This method is used to click on Details button
	 */
	public void clickOnDetailsBtn()
	{
		detailsBtn.click();
	}
}
