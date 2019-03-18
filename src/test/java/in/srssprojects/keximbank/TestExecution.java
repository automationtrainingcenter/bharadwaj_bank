package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class TestExecution extends BaseClass {
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	BranchDetailsPage branchDetailsPage;
	BranchCreationPage branchCreationPage;
	
	Alert alert;
	String actualText;

	@Test(priority  = 0)
	public void testBrowserLaunch() {
		launchBrowser(readProperty("browserName"), readProperty("url"));
		bankHomePage = new BankHomePage(driver);
		Assert.assertTrue(bankHomePage.verifyBankHomePage());
	}

	@Test(priority  = 1)
	public void loginWithValidData() {
		bankHomePage.fillUserName(readProperty("username"));
		bankHomePage.fillPassword(readProperty("password"));
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.verifyAdminHomePage());
	}

	@Test(priority  = 2)
	public void roleCreationWithValidData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCrationForm(TestData.ROLENAME, TestData.ROLETYPE);
		alert = roleCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("created sucessfully", actualText));
	}
	
	@Test(priority  = 3)
	public void roleCreationWithDuplicateData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCrationForm(TestData.ROLENAME, TestData.ROLETYPE);
		alert = roleCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("Already existed", actualText));
	}
	
	@Test(priority  = 4)
	public void roleCrationWithBlankData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		alert = roleCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("Please fill in the following", actualText));
	}
	
	@Test(priority  = 5)
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCrationForm(TestData.ROLENAME, TestData.ROLETYPE);
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isRoleNameEmpty());
	}

	@Test(priority  = 6)
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleDetailsPage = roleCreationPage.clickCancel();
		Assert.assertTrue(roleDetailsPage.isNewRoleButtonDisplayed());
	}
	
	@Test(priority  = 7)
	public void branchCreationWithValidData() {
		branchDetailsPage = adminHomePage.clickBranches();
        branchCreationPage=branchDetailsPage.clickNewBranchButton();
        branchCreationPage.fillBranchCreationForm(TestData.BRANCHNAME, TestData.ADDRESS1, TestData.AREA, TestData.ZIPCODE, TestData.COUNTRY, TestData.STATE, TestData.CITY);
		alert = branchCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertFalse(validataAlertText("created sucessfully", actualText));

	}
	
	
	@Test(priority  = 20)
	public void logoutAndClose() {
		adminHomePage.clickLogout();
		closeBrowser();
	}
	

}
