package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.DropdownUtility;
import com.tyss.genericUtility.WebActions.WaitUtility;

public class UpdatePageDataPage {
	
	//declaration
	@FindBy(xpath = "//select[@name='menu1']") private WebElement selectMenu;
	@FindBy(xpath = "//div[contains(@class,'nicEdit-main')] ") private WebElement aboutusTxtField;
	@FindBy(id = "submit") private WebElement updateBtn;
	
	/**
	 * initialization
	 * @param driver
	 */
	public UpdatePageDataPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to select the menu lit from dropdown
	 * @param d
	 * @param text
	 */
	public void selectMenu(DropdownUtility d, String text)
	{
		d.handleDropdown(text, selectMenu);
	}
	
	/**
	 * 
	 */
	public void aboutusTxtField()
	{
		aboutusTxtField.clear();
	}
	/**
	 * 
	 * @param value
	 * @param w
	 */
	public void aboutusTxtFieldData(String value, WaitUtility w)
	{
		w.waitForElementToBeVisible(aboutusTxtField);
		aboutusTxtField.sendKeys(value);
	}
	
	/**
	 * This method is used to click on update button
	 */
	public void clickUpdate() {
		updateBtn.click();
	}
}
