package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.JavaScriptUtility;

public class ManageUsersPage {
	
	//declaration
	@FindBy(xpath = "//table/tbody/tr[last()]/td[4]") private WebElement emailTxt;
	
	/**
	 * initialization
	 * @param driver
	 */
	public ManageUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to fetch the data from manage users page
	 * @param j
	 * @return
	 */
	public String emailIdText(JavaScriptUtility j)
	{
		j.scrollDown();
		return emailTxt.getText();
	}
}
