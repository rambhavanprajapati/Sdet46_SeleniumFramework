package tms.mb.admin;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.tyss.genericUtility.annotation.Report;
import com.tyss.genericUtility.configuration.ConfigClass;
import com.tyss.genericUtility.enums.ExcelSheet;
import com.tyss.genericUtility.misc.UtilityInstanceTransfer;

import tms.movingBird.elementRepository.AdminLoginPage;
import tms.movingBird.elementRepository.ConfirmationPage;
import tms.movingBird.elementRepository.CreatePackagePage;
import tms.movingBird.elementRepository.ManagePackagePage;
import tms.movingBird.elementRepository.TourPackagesPage;
import tms.movingBird.elementRepository.UpdatePackagePage;
import tms.movingBird.elementRepository.enums.LinkNames;
@Listeners(com.tyss.genericUtility.listener.ExtentReportListener.class)
public class AdminCreatePackage_UpdateSamePackageTest extends ConfigClass {

	@Report(author = "ram" , category = "sanity")
	@Test(groups = "sanity")
	public void adminCreatePackage_UpdateSamePackageTest()
	{
		//test data
		String expPackageName = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.ADMIN.getSheetName(), "create package", "packagename")+jUtil.getRandomNumber(1000);
		report.info(UtilityInstanceTransfer.getExtentTest(), "Expected Package Name--> "+expPackageName);
		String location = eUtil.fetchDataFromExcelUsingMap(ExcelSheet.ADMIN.getSheetName(), "create package", "packagename");
		Map<String, String> excelData = eUtil.getData(ExcelSheet.ADMIN.getSheetName(), "create package");
		report.info(UtilityInstanceTransfer.getExtentTest(), "Test data fetched successfully");
		report.info(UtilityInstanceTransfer.getExtentTest(), excelData+"");
		
		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		TourPackagesPage tourPackagePage = new TourPackagesPage(driver);
		CreatePackagePage createPackagePage = new CreatePackagePage(driver);
		UpdatePackagePage updatePackagePage = new UpdatePackagePage(driver);
		ManagePackagePage managePackagePage = new ManagePackagePage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		report.info(UtilityInstanceTransfer.getExtentTest(), "Required objects for POM classes created successfully");
		
		homePage.clickLink(LinkNames.ADMIN_LOGIN);
		adminLoginPage.adminLoginAction(adminUserId, adminPassword);
		tourPackagePage.createAction(iUtil);
		createPackagePage.setDataIntoTextField(excelData, jsUtil);
		createPackagePage.submitAction();
		String expected = "Package Created Successfully";
		String actual = confirmationPage.packageCreatedtext();
		Assert.assertTrue(actual.contains(expected), actual);
		tourPackagePage.manageAction(iUtil);
		managePackagePage.clickOnLastViewBtn(jsUtil);
		updatePackagePage.packageNameTxtField(expPackageName);
		updatePackagePage.packageLocationTxtField(location);
		updatePackagePage.submitBtnAction(jsUtil);
		String manage_expected = "Package Updated Successfully";
		String manage_actual = confirmationPage.packageCreatedtext();
		Assert.assertTrue(manage_actual.contains(manage_expected), manage_actual);

	}

}