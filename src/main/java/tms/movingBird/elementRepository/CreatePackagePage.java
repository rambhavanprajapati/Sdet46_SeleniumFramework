package tms.movingBird.elementRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.genericUtility.WebActions.JavaScriptUtility;


public class CreatePackagePage {

	private WebDriver driver;
	
	//declaration                            //"//input[@id='%s']"
	String packageInfoTxtFieldPartialLocator = "%s";
	@FindBy(name = "submit") private WebElement submitBtn;
	
	/**
	 * This method is used to convert partial xpath String into WebElement
	 * @param partialXpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertToWebElement(String partialLocator, String replaceData)
	{
		String idLocator = String.format(partialLocator, replaceData);
		return driver.findElement(By.id(idLocator));
	}
	
	/**
	 * initialization
	 * @param driver
	 */
	public CreatePackagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used to set the data in all field from excel sheet
	 * @param packageInfo
	 */
	public void setDataIntoTextField(Map<String, String> packageInfo, JavaScriptUtility j)
	{
		for(Entry<String, String> keyValue : packageInfo.entrySet()) {
			String key = keyValue.getKey();
			if(key.equals("packagedetails"))
			{
				j.scrollDown();
				convertToWebElement(packageInfoTxtFieldPartialLocator, keyValue.getKey()).sendKeys(keyValue.getValue());
			}
			else
			convertToWebElement(packageInfoTxtFieldPartialLocator, keyValue.getKey()).sendKeys(keyValue.getValue());
		}
	}
	
	/**
	 * This method is used to perform click action for submit the package
	 */
	public void submitAction()
	{
		submitBtn.click();
	}	
	
}
