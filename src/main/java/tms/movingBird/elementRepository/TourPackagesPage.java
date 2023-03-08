package tms.movingBird.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.InteractionUtility;

public class TourPackagesPage {
	
	//declaration
	@FindBy(xpath = "//span[.=' Tour Packages']") private WebElement tourPackage;
	@FindBy(linkText = "Create") private WebElement createLink;
	@FindBy(linkText = "Manage") private WebElement manageLink;
	
	/**
	 * initialization
	 * @param driver
	 */
	public TourPackagesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to perform click action for create button
	 */
	public void createAction(InteractionUtility i)
	{
		i.mouseHoverAction(tourPackage);
		createLink.click();
	}
	
	/**
	 * This method is used to perform click action for manage button
	 */
	public void manageAction(InteractionUtility i)
	{
		i.mouseHoverAction(tourPackage);
		manageLink.click();
	}

}
