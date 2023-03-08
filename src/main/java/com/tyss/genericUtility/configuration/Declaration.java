package com.tyss.genericUtility.configuration;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.tyss.genericUtility.WebActions.DropdownUtility;
import com.tyss.genericUtility.WebActions.InteractionUtility;
import com.tyss.genericUtility.WebActions.JavaScriptUtility;
import com.tyss.genericUtility.WebActions.PopupsUtility;
import com.tyss.genericUtility.WebActions.WaitUtility;
import com.tyss.genericUtility.WebActions.WebDriverUtility;
import com.tyss.genericUtility.externalFileUtility.ExcelFileUtility;
import com.tyss.genericUtility.externalFileUtility.PropertyFileUtility;
import com.tyss.genericUtility.misc.JavaUtility;
import com.tyss.genericUtility.misc.ReportUtility;
import com.tyss.genericUtility.misc.VerificationUtility;

import tms.movingBird.elementRepository.HomePage;
/**
 * This class contains declaration of all generic utilities and common data and common page
 * @author Zero Touch
 *
 */
public class Declaration {
	
	protected PropertyFileUtility pUtil;
	protected ExcelFileUtility eUtil;
	public WebDriverUtility wUtil;
	protected WaitUtility waitUtil;
	protected PopupsUtility popupUtil;
	protected VerificationUtility vUtil;
	public JavaUtility jUtil;
	protected DropdownUtility dropdownUtil;
	protected WebDriver driver;
	protected String adminUserId;
	protected String adminPassword;
	protected String userEmailId;
	protected String userPassword;
	protected String url;
	protected String browser;
	protected long timeunit;
	protected JavaScriptUtility jsUtil;
	protected InteractionUtility iUtil;
	protected HomePage homePage;
	protected ReportUtility report;
	public ExtentTest test;
	
}
