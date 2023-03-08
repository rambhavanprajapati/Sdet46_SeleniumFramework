package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSignUpPage {
	
	//declaration
	@FindBy(name = "fname") private WebElement firstNameTxtField;
	
	@FindBy(name = "mobilenumber") private WebElement mobileNoTxtField;

	@FindBy(css = "[placeholder='Email id']") private WebElement emailIdTxtField;
	
	@FindBy(name = "password") private WebElement passwordTxtField;
	
	@FindBy(id = "submit") private WebElement createAccountBtn;

	/**
	 * initialization
	 * @param driver
	 */
	public UserSignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform signup Action for user
	 * @param firstName
	 * @param mobileNo
	 * @param emailId
	 * @param password
	 */
	public void createAccountAction(String firstName, String mobileNo, String emailId, String password)
	{
		firstNameTxtField.sendKeys(firstName);
		mobileNoTxtField.sendKeys(mobileNo);
		emailIdTxtField.sendKeys(emailId);
		passwordTxtField.sendKeys(password);
		createAccountBtn.click();
	}
}
