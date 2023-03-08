package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignInPage {
	
	//declaration
	@FindBy(css = "[placeholder='Enter your Email']") private WebElement emailTxtField;
	
	@FindBy(id = "password") private WebElement passwordTxtField;
	
	@FindBy(name = "signin") private WebElement signInBtn;
	
	/**
	 * initialization
	 * @param driver
	 */
	public UserSignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to perform login Action for user
	 * @param emailId
	 * @param password
	 */
	public void userSignInAction(String emailId, String password)
	{
		emailTxtField.sendKeys(emailId);
		passwordTxtField.sendKeys(password);
		signInBtn.click();
	}
	
}
