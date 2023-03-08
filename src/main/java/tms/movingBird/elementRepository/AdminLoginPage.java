package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	//declaration
	@FindBy(name = "username") private WebElement usernameTxtField;
	
	@FindBy(name = "password") private WebElement passwordTxtField;
	
	@FindBy(name = "login") private WebElement loginBtn;
	
	@FindBy(linkText = "Back to home") private WebElement backToHomeLink;
	
	/**
	 * initialization
	 * @param driver
	 */
	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to perform login Action for admin
	 * @param username
	 * @param password
	 */
	public void adminLoginAction(String username, String password)
	{
		usernameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginBtn.click();
	}
	
	/**
	 * This method is used to perform click action to get home page 
	 */
	public void clickOnBackToHome()
	{
		backToHomeLink.click();
	}
}
