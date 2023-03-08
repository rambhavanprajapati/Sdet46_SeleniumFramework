package tms.mb.admin;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtility.annotation.Report;
import com.tyss.genericUtility.configuration.ConfigClass;
import com.tyss.genericUtility.enums.ExcelSheet;
import tms.movingBird.elementRepository.AdminLoginPage;
import tms.movingBird.elementRepository.AdministratorPage;
import tms.movingBird.elementRepository.ConfirmationPage;
import tms.movingBird.elementRepository.DashboardPage;
import tms.movingBird.elementRepository.ManagePackagePage;
import tms.movingBird.elementRepository.PackageListPage;
import tms.movingBird.elementRepository.TourPackagesPage;
import tms.movingBird.elementRepository.UpdatePackagePage;
import tms.movingBird.elementRepository.UserSignInPage;
import tms.movingBird.elementRepository.enums.LinkNames;
import tms.movingBird.elementRepository.enums.TabNames;

public class ManagePackageTest extends ConfigClass{

	@Report(author = "Ram")
	@Test(groups = "regression")
	public void managePackageTest() {
		
		//test data
		String expPackageName = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.ADMIN.getSheetName(), "create package", "packagename")+new Random().nextInt(1000);
		System.out.println(expPackageName);
		String location = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.ADMIN.getSheetName(), "create package", "packagename");
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		TourPackagesPage tourPackagePage = new TourPackagesPage(driver);
		AdministratorPage administratorPage = new AdministratorPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		ManagePackagePage managePackagePage = new ManagePackagePage(driver);
		UpdatePackagePage updatePackagePage = new UpdatePackagePage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		PackageListPage packageListPage = new PackageListPage(driver);
		
		homePage.clickLink(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginAction(adminUserId, adminPassword);
		tourPackagePage.manageAction(iUtil);
		managePackagePage.scrollTillElement(jsUtil);
		managePackagePage.clickOnViewAction();
		updatePackagePage.packageNameTxtField(expPackageName);
		updatePackagePage.packageLocationTxtField(location);
		updatePackagePage.submitBtnAction(jsUtil);
		String expected = "Package Updated Successfully";
		String actual = confirmationPage.packageCreatedtext();
		Assert.assertTrue(actual.contains(expected), actual);
		dashboardPage.clickLink(TabNames.ADMINISTRATOR);
		administratorPage.adminLogoutAction();
		adminLoginPage.clickOnBackToHome();
		homePage.clickLink(LinkNames.SIGN_IN);
		userSignInPage.userSignInAction(userEmailId, userPassword);
		homePage.clickLink(LinkNames.TOUR_PACKAGES);
		packageListPage.waitForElement(waitUtil, jsUtil);
		String actPackageName = packageListPage.getTextOfElement();
		System.out.println(actPackageName);
		Assert.assertTrue(actPackageName.contains(expPackageName), actPackageName);
	}

}
