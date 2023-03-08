package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.JavaScriptUtility;

public class ManagePackagePage {
	
	//declaration
	@FindBy(xpath = "//tbody/tr[42]/td[1]/span[text()='42']") private WebElement element;
	@FindBy(xpath = "//tbody/tr[42]/td[7]/descendant::button[text()='View Details']") private WebElement viewBtn;
	@FindBy(xpath = "//tbody/tr[last()]/td[7]/descendant::button[text()='View Details']") private WebElement lastViewBtn;
	
	/**
	 * initialization
	 * @param driver
	 */
	public ManagePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to scroll upto particular element
	 * @param j
	 */
	public void scrollTillElement(JavaScriptUtility j)
	{
		j.scrollTillElement(element);
	}
	
	/**
	 * This method is used to click on view Button of the last of webpage 
	 */
	public void clickOnLastViewBtn(JavaScriptUtility j)
	{
		j.scrollDown();
		lastViewBtn.click();
	}
	
	/**
	 * This method is used to click on a particular view button
	 */
	public void clickOnViewAction()
	{
		viewBtn.click();
	}
}
