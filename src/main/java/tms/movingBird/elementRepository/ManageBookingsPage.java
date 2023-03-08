package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.JavaScriptUtility;

public class ManageBookingsPage {
	
	//declaration
	@FindBy(xpath = "//table[@id='table']/tbody/tr[last()]/td[last()]//a[text()='Confirm']") private WebElement confirmBtn;
	@FindBy(xpath = "//table[@id='table']/tbody/tr[last()]/td[last()]//a[text()='Cancel']") private WebElement cancelBtn;
	
	/**
	 * initialization
	 * @param driver
	 */
	public ManageBookingsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to perform click action for confirm button
	 */
	public void confirmPackageAction(JavaScriptUtility j)
	{
		j.scrollDown();
		confirmBtn.click();
	}
	
	/**
	 * This method is used to perform click action for cancel button
	 */
	public void cancelPackageAction(JavaScriptUtility j)
	{
		j.scrollDown();
		cancelBtn.click();
	}
}
