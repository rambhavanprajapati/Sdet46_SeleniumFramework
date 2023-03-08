package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdministratorPage {
	
	//declaration
	@FindBy(xpath = "//a[@href='logout.php']") private WebElement logoutBtn;
	@FindBy(xpath = "//a[@href='change-password.php']") private WebElement profileBtn;
	
	/**
	 * initialization
	 * @param driver
	 */
	public AdministratorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to logout for admin
	 */
	public void adminLogoutAction()
	{
		logoutBtn.click();
	}
	
	/**
	 * This method is used to show the profile of admin
	 */
	public void adminProfileAction()
	{
		profileBtn.click();
	}
}
