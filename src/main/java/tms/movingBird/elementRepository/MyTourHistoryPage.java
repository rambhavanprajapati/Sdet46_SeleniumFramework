package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTourHistoryPage {
	
	//declaration
	@FindBy(xpath = "//table/tbody/tr[last()]/td[7]") private WebElement cancelStatus;
	
	/**
	 * initialization
	 * @param driver
	 */
	public MyTourHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to fetch the data from my tour history page
	 * @return
	 */
	public String statusText()
	{
		return cancelStatus.getText();
	}

}
