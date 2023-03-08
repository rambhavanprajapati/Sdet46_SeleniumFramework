package tms.mb.admin;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tyss.genericUtility.annotation.Report;
import com.tyss.genericUtility.configuration.ConfigClass;
import com.tyss.genericUtility.enums.ExcelSheet;
import com.tyss.genericUtility.misc.UtilityInstanceTransfer;

import tms.movingBird.elementRepository.AdminLoginPage;
import tms.movingBird.elementRepository.AdministratorPage;
import tms.movingBird.elementRepository.ConfirmationPage;
import tms.movingBird.elementRepository.CreatePackagePage;
import tms.movingBird.elementRepository.DashboardPage;
import tms.movingBird.elementRepository.PackageListPage;
import tms.movingBird.elementRepository.TourPackagesPage;
import tms.movingBird.elementRepository.UserHomePage;
import tms.movingBird.elementRepository.UserSignInPage;
import tms.movingBird.elementRepository.enums.LinkNames;
import tms.movingBird.elementRepository.enums.TabNames;
@Listeners(com.tyss.genericUtility.listener.ExtentReportListener.class)
public class CreatePackageTest extends ConfigClass {
	
	@Report(author = "gaurav" , category = "sanity")
	@Test(groups="sanity")
	public void createPackageTest() {
		
		//test data
		String expPackageName = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.ADMIN.getSheetName(), "create package", "packagename");//+new Random().nextInt(1000);
		report.info(UtilityInstanceTransfer.getExtentTest(), "Expected Package Name--> "+expPackageName);
		Map<String, String> excelData = eUtil.getData(ExcelSheet.ADMIN.getSheetName(), "create package");
		report.info(UtilityInstanceTransfer.getExtentTest(), "Test data fetched successfully");
		report.info(UtilityInstanceTransfer.getExtentTest(), excelData+"");
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		TourPackagesPage tourPackagePage = new TourPackagesPage(driver);
		CreatePackagePage createPackagePage = new CreatePackagePage(driver);
		AdministratorPage administratorPage = new AdministratorPage(driver);
		UserHomePage userHomePage = new UserHomePage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		PackageListPage packageListPage = new PackageListPage(driver);
		report.info(UtilityInstanceTransfer.getExtentTest(), "Required objects for POM classes created successfully");

		homePage.clickLink(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginAction(adminUserId, adminPassword);
		tourPackagePage.createAction(iUtil);
		createPackagePage.setDataIntoTextField(excelData, jsUtil);
		createPackagePage.submitAction();
		String expected = "Package Created Successfully";
		String actual = confirmationPage.packageCreatedtext();
		Assert.assertTrue(actual.contains(expected),"package created successfully cpt1");
		dashboardPage.clickLink(TabNames.ADMINISTRATOR);
		administratorPage.adminLogoutAction();
		adminLoginPage.clickOnBackToHome();
		userHomePage.clickLink(LinkNames.SIGN_IN);
		userSignInPage.userSignInAction(userEmailId, userPassword);
		homePage.clickLink(LinkNames.TOUR_PACKAGES);
		packageListPage.waitForElement(waitUtil, jsUtil);
		String actPackageName = packageListPage.getTextOfElement();
		Assert.assertTrue(actPackageName.contains(expPackageName), actPackageName);
	}
}
