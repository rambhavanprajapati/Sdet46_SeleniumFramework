package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	
	//declaration
	@FindBy(xpath = "//div[@class='succWrap']") private WebElement packageCreatedtext;
	
	/**
	 * initialization
	 * @param driver
	 */
	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to fetch the confirmation message
	 * @return
	 */
	public String packageCreatedtext()
	{
		return packageCreatedtext.getText();
	}

}
