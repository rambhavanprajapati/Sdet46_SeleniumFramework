package com.tyss.genericUtility.configuration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tyss.genericUtility.WebActions.DropdownUtility;
import com.tyss.genericUtility.WebActions.InteractionUtility;
import com.tyss.genericUtility.WebActions.JavaScriptUtility;
import com.tyss.genericUtility.WebActions.PopupsUtility;
import com.tyss.genericUtility.WebActions.WaitUtility;
import com.tyss.genericUtility.WebActions.WebDriverUtility;
import com.tyss.genericUtility.constants.IConstantsUtility;
import com.tyss.genericUtility.enums.PropertyKey;
import com.tyss.genericUtility.externalFileUtility.ExcelFileUtility;
import com.tyss.genericUtility.externalFileUtility.PropertyFileUtility;
import com.tyss.genericUtility.listener.ExtentReportListener;
import com.tyss.genericUtility.misc.JavaUtility;
import com.tyss.genericUtility.misc.VerificationUtility;

import tms.movingBird.elementRepository.HomePage;
/**
 * This class contains TestNG configuration of common actions
 * @author Zero Touch
 *
 */
public class ConfigClass extends Declaration{

	/**
	 * This method is used to initiallize the generic utilities class and common data
	 * also it will launch the browser and application
	 */
	@Parameters(value = "browser")
	@BeforeClass(alwaysRun = true)
	public void btConfig(@Optional String browser)
	{
		pUtil = new PropertyFileUtility(IConstantsUtility.TEST_PROPERTY_FILE_PATH);
		eUtil = new ExcelFileUtility(IConstantsUtility.TEST_EXCEL_FILE_PATH);
		wUtil = new WebDriverUtility();
		popupUtil = new PopupsUtility();
		vUtil = new VerificationUtility();
		jUtil = new JavaUtility();
		dropdownUtil = new DropdownUtility();
		report=ExtentReportListener.sreport;
		//common data
		if(browser==null || browser.isEmpty() || browser.equals(""))
		{
			browser=pUtil.getPropertyData(PropertyKey.BROWSER);
		}
		this.browser=browser;
		adminUserId = jUtil.decode(pUtil.getPropertyData(PropertyKey.ADMIN_USER_ID));
		adminPassword = jUtil.decode(pUtil.getPropertyData(PropertyKey.ADMIN_PASSWORD));
		userEmailId = pUtil.getPropertyData(PropertyKey.USER_EMAIL_ID);
		userPassword = jUtil.decode(pUtil.getPropertyData(PropertyKey.USER_PASSWORD));
		timeunit = Long.parseLong(pUtil.getPropertyData(PropertyKey.TIMEUNIT));
		url = pUtil.getPropertyData(PropertyKey.URL);
		
		driver = wUtil.launchBrowser(browser,"");
		homePage = new HomePage(driver);
		waitUtil = new WaitUtility(driver, timeunit);
		jsUtil = new JavaScriptUtility(driver);
		iUtil = new InteractionUtility(driver);
		wUtil.maximiseWindow();
		waitUtil.waitForPageLoad(driver, timeunit);
		wUtil.launchApplication(url);
	}

	/**
	 * This method is used to close the browser
	 */
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		eUtil.close();
	}
}
