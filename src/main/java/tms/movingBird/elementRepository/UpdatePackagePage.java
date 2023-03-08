package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.JavaScriptUtility;

public class UpdatePackagePage {
	
	//declaration
	@FindBy(id = "packagename") private WebElement packageNameTxtField;
	@FindBy(id = "packagelocation") private WebElement packageLocationTxtField;
	@FindBy(name = "submit") private WebElement submitBtn;
	
	/**
	 * initialization
	 * @param driver
	 */
	public UpdatePackagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to clear and send data into package name text field 
	 * @param data
	 */
	public void packageNameTxtField(String data)
	{
		packageNameTxtField.clear();
		packageNameTxtField.sendKeys(data);
	}
	
	/**
	 * This method is used to clear and send data into package location text field
	 * @param data
	 */
	public void packageLocationTxtField(String data)
	{
		packageLocationTxtField.clear();
		packageLocationTxtField.sendKeys(data);
	}
	
	/**
	 * This method is used to perform click action on submit button
	 * @param j
	 */
	public void submitBtnAction(JavaScriptUtility j)
	{
		j.scrollAction();
		submitBtn.click(); 
	}
}
