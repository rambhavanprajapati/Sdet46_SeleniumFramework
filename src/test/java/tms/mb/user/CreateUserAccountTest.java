package tms.mb.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtility.annotation.Report;
import com.tyss.genericUtility.configuration.ConfigClass;
import com.tyss.genericUtility.enums.ExcelSheet;
import tms.movingBird.elementRepository.AdminLoginPage;
import tms.movingBird.elementRepository.DashboardPage;
import tms.movingBird.elementRepository.ManageUsersPage;
import tms.movingBird.elementRepository.UserHomePage;
import tms.movingBird.elementRepository.UserSignInPage;
import tms.movingBird.elementRepository.UserSignUpPage;
import tms.movingBird.elementRepository.enums.LinkNames;
import tms.movingBird.elementRepository.enums.TabNames;

public class CreateUserAccountTest extends ConfigClass{
	
	@Report(author = "Ram")
	@Test(groups = {"regression","minor"})
	public void createUserAccountTest(){
		
		//test data
		String username = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.USER.getSheetName(), "create account", "username");
		String domain = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.USER.getSheetName(), "create account", "domain");
		String actualEmailID = username+jUtil.getRandomNumber(1000)+domain;
		String mobileNo = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.USER.getSheetName(), "create account", "mobilenumber");
		String password = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.USER.getSheetName(), "create account", "password");

		UserSignInPage userSignInPage = new UserSignInPage(driver);
		UserSignUpPage userSignUpPage = new UserSignUpPage(driver);
		UserHomePage userHomePage = new UserHomePage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		ManageUsersPage manageUserPage = new ManageUsersPage(driver);

		homePage.clickLink(LinkNames.SIGN_UP);
		userSignUpPage.createAccountAction(username, mobileNo, actualEmailID, password);
		homePage.clickLink(LinkNames.SIGN_IN);
		userSignInPage.userSignInAction(actualEmailID, password);
		userHomePage.clickLink(LinkNames.MY_PROFILE);
		homePage.clickLink(LinkNames.LOGOUT);
		homePage.clickLink(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginAction(adminUserId, adminPassword);
		dashboardPage.clickLink(TabNames.MANAGE_USERS);
		String expEmailID = manageUserPage.emailIdText(jsUtil);
		Assert.assertEquals(actualEmailID, expEmailID, actualEmailID);

	}

}
