package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage {
	
	//declaration
	@FindBy(xpath = "//p[contains(text(),'providing best facilities')]") private WebElement aboutTxt;
	
	/**
	 * initillization
	 * @param driver
	 */
	public AboutUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	 /**
	  * This method is used to fetch the data present in about us page
	  * @return
	  */
	public String aboutTxt()
	{
		return aboutTxt.getText();
	}

}
