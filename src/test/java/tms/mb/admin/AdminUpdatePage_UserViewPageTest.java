package tms.mb.admin;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtility.annotation.Report;
import com.tyss.genericUtility.configuration.ConfigClass;
import com.tyss.genericUtility.enums.ExcelSheet;

import tms.movingBird.elementRepository.AboutUsPage;
import tms.movingBird.elementRepository.AdminLoginPage;
import tms.movingBird.elementRepository.AdministratorPage;
import tms.movingBird.elementRepository.ConfirmationPage;
import tms.movingBird.elementRepository.DashboardPage;
import tms.movingBird.elementRepository.UpdatePageDataPage;
import tms.movingBird.elementRepository.UserSignInPage;
import tms.movingBird.elementRepository.enums.LinkNames;
import tms.movingBird.elementRepository.enums.TabNames;

public class AdminUpdatePage_UserViewPageTest extends ConfigClass{
	
	@Report(author = "Ram")
	@Test(groups = {"regression", "minor"})
	public void adminUpdatePage_UserViewPage()
	{
		//test data
		String aboutus = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.ADMIN.getSheetName(), "updatepage", "aboutus");
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		UpdatePageDataPage updatePageDataPage = new UpdatePageDataPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		AdministratorPage administratorPage = new AdministratorPage(driver);
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		AboutUsPage aboutUsPage = new AboutUsPage(driver);
		
		homePage.clickLink(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginAction(adminUserId, adminPassword);
		dashboardPage.clickLink(TabNames.MANAGE_PAGES);
		updatePageDataPage.selectMenu(dropdownUtil, "aboutus");
		updatePageDataPage.aboutusTxtField();
		updatePageDataPage.aboutusTxtFieldData(aboutus, waitUtil);
		updatePageDataPage.clickUpdate();
		String expResult = "Page data updated successfully";
		String actResult = confirmationPage.packageCreatedtext();
		Assert.assertTrue(actResult.contains(expResult), actResult);
		dashboardPage.clickLink(TabNames.ADMINISTRATOR);
		administratorPage.adminLogoutAction();
		adminLoginPage.clickOnBackToHome();
		homePage.clickLink(LinkNames.SIGN_IN);
		userSignInPage.userSignInAction(userEmailId, userPassword);
		homePage.clickLink(LinkNames.ABOUT);
		String actualAboutUs = aboutUsPage.aboutTxt();
		assertTrue(actualAboutUs.contains(aboutus), actualAboutUs);
		
	}

}
