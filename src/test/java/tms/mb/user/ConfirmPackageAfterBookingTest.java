package tms.mb.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.genericUtility.annotation.Report;
import com.tyss.genericUtility.configuration.ConfigClass;
import com.tyss.genericUtility.enums.ExcelSheet;
import tms.movingBird.elementRepository.AdminLoginPage;
import tms.movingBird.elementRepository.AdministratorPage;
import tms.movingBird.elementRepository.ConfirmationPage;
import tms.movingBird.elementRepository.DashboardPage;
import tms.movingBird.elementRepository.ManageBookingsPage;
import tms.movingBird.elementRepository.MyTourHistoryPage;
import tms.movingBird.elementRepository.PackageDetailsPage;
import tms.movingBird.elementRepository.PackageListPage;
import tms.movingBird.elementRepository.UserHomePage;
import tms.movingBird.elementRepository.UserSignInPage;
import tms.movingBird.elementRepository.enums.LinkNames;
import tms.movingBird.elementRepository.enums.TabNames;

public class ConfirmPackageAfterBookingTest extends ConfigClass{

	@Report(author = "Ram")
	@Test(groups = {"regression","major"})
	public void confirmPackageAfterBookingTest() {
		
		//test data
		String comment = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.USER.getSheetName(), "book package", "comment");
		
		UserSignInPage userSignInPage = new UserSignInPage(driver);
		PackageListPage packageListPage = new PackageListPage(driver);
		PackageDetailsPage packageDetailsPage = new PackageDetailsPage(driver);
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		DashboardPage dashboardPage = new DashboardPage(driver);
		ManageBookingsPage manageBookingPage = new ManageBookingsPage(driver);
		AdministratorPage administratorPage = new AdministratorPage(driver);
		UserHomePage userHomePage = new UserHomePage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		MyTourHistoryPage myTourHistoryPage = new MyTourHistoryPage(driver);
		
		homePage.clickLink(LinkNames.SIGN_IN);
		userSignInPage.userSignInAction(userEmailId, userPassword);
		userHomePage.clickLink(LinkNames.TOUR_PACKAGES);
		packageListPage.scrollTillElement(jsUtil);
		packageListPage.clickOnDetailsBtn();
		jsUtil.scrollAction();
		packageDetailsPage.clickOnDateField(LinkNames.FROM_DATE);
		packageDetailsPage.clickOnDate("24");
		packageDetailsPage.clickOnDateField(LinkNames.TO_DATE);
		packageDetailsPage.clickOnDate("26");
		packageDetailsPage.commentTxtField(comment);
		packageDetailsPage.bookBtnAction();
		String expected = "Booked Successfully";
		String actual = confirmationPage.packageCreatedtext();
		Assert.assertTrue(actual.contains(expected), actual);
		homePage.clickLink(LinkNames.LOGOUT);
		homePage.clickLink(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginAction(adminUserId, adminPassword);
		dashboardPage.clickLink(TabNames.MANAGE_BOOKING);
		manageBookingPage.confirmPackageAction(jsUtil);
		popupUtil.confirmAlert(driver);
		String expected_2 = "Booking Confirm successfully";
		String actual_2 = confirmationPage.packageCreatedtext();
		Assert.assertTrue(actual_2.contains(expected_2), actual_2);
		dashboardPage.clickLink(TabNames.ADMINISTRATOR);
		administratorPage.adminLogoutAction();
		adminLoginPage.clickOnBackToHome();
		homePage.clickLink(LinkNames.SIGN_IN);
		userSignInPage.userSignInAction(userEmailId, userPassword);
		userHomePage.clickLink(LinkNames.MY_TOUR_HISTORY);
		String exp_status = "Confirmed";
		String act_status = myTourHistoryPage.statusText();
		Assert.assertTrue(act_status.contains(exp_status), act_status);

	}

}
