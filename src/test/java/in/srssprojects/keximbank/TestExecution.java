package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.BaseClass;

public class TestExecution extends BaseClass {
	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	BranchDetailsPage branchDetailsPage;
	BranchCreationPage branchCreationPage;
	EmployeeDetailsPage employeeDetailsPage;
	EmployeeCreationPage employeeCreationPage;

	Alert alert;
	String actualText;

	

	@Test(priority = 1, groups = { "role", "branch", "employee", "create", "reset", "cancel", "valid", "invlaid",
			"duplicate" })
	public void loginWithValidData() {
		bankHomePage.fillUserName(readProperty("username"));
		bankHomePage.fillPassword(readProperty("password"));
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.verifyAdminHomePage());
	}

	@Test(priority = 2, groups = { "role", "create", "valid" })
	public void roleCreationWithValidData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCrationForm(TestData.ROLENAME, TestData.ROLETYPE);
		alert = roleCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("created Sucessfully", actualText));
	}

	@Test(priority = 3, groups = { "role", "create", "duplicate" }, dependsOnMethods = { "roleCreationWithValidData" })
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

	@Test(priority = 4, groups = { "role", "create", "invalid" })
	public void roleCrationWithBlankData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		alert = roleCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("Please fill in the following", actualText));
	}

	@Test(priority = 5, groups = { "role", "reset" })
	public void roleCreationReset() {
		System.out.println("executing role creation reset");
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleCreationPage.fillRoleCrationForm(TestData.ROLENAME, TestData.ROLETYPE);
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isRoleNameEmpty());
	}

	@Test(priority = 6, groups = { "role", "cancel" })
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRoleButton();
		roleDetailsPage = roleCreationPage.clickCancel();
		Assert.assertTrue(roleDetailsPage.isNewRoleButtonDisplayed());
	}

	@Test(priority = 7, groups = { "branch", "create", "valid" })
	public void branchCreationWithValidData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm(TestData.BRANCHNAME, TestData.ADDRESS1, TestData.AREA,
				TestData.ZIPCODE, TestData.COUNTRY, TestData.STATE, TestData.CITY);
		alert = branchCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("created Sucessfully", actualText));

	}

	@Test(priority = 8, groups = { "branch", "create", "duplicate" })
	public void branchCreationWithDuplicatedData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm(TestData.BRANCHNAME, TestData.ADDRESS1, TestData.AREA,
				TestData.ZIPCODE, TestData.COUNTRY, TestData.STATE, TestData.CITY);
		alert = branchCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("already exist", actualText));
	}

	@Test(priority = 9, groups = { "branch", "create", "invalid" })
	public void branchCreationWithBlankData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		alert = branchCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		System.out.println(actualText);
		Assert.assertTrue(validataAlertText("Please fill in the following", actualText));

	}

	@Test(priority = 10, groups = { "branch", "reset" })
	public void branchCreationReset() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchCreationPage.fillBranchCreationForm(TestData.BRANCHNAME, TestData.ADDRESS1, TestData.AREA,
				TestData.ZIPCODE, TestData.COUNTRY, TestData.STATE, TestData.CITY);
		branchCreationPage.clickReset();
		Assert.assertTrue(branchCreationPage.isBranchNameEmpty());
	}

	@Test(priority = 11, groups = { "branch", "cancel" })
	public void branchCreationCancel() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranchButton();
		branchDetailsPage = branchCreationPage.clickCancel();
		Assert.assertTrue(branchDetailsPage.isNewBranchButtonDisplayed());
	}

	@Test(priority = 12, groups = { "employee", "create", "valid" })
	public void employeeCreationWithValid() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeCreationForm(TestData.EMPNAME, TestData.LOGINPASSWORD, TestData.ROLENAME,
				TestData.BRANCHNAME);
		alert = employeeCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		Assert.assertTrue(validataAlertText("Successfully", actualText));
	}

	@Test(priority = 13, groups = { "employee", "create", "duplicate" })
	public void employeeCreationWithDuplicateData() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeCreationForm(TestData.EMPNAME, TestData.LOGINPASSWORD, TestData.ROLENAME,
				TestData.BRANCHNAME);
		alert = employeeCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		Assert.assertTrue(validataAlertText("Already Existed", actualText));
	}

	@Test(priority = 14, groups = { "employee", "create", "invalid" })
	public void employeeCreationWithBlankData() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		alert = employeeCreationPage.clickSubmit();
		actualText = alert.getText();
		alert.accept();
		Assert.assertTrue(validataAlertText("Please fill in the following", actualText));
	}

	@Test(priority = 15, groups = { "employee", "reset" })
	public void employeeCreationReset() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeCreationPage.fillEmployeeCreationForm(TestData.EMPNAME, TestData.LOGINPASSWORD, TestData.ROLENAME,
				TestData.BRANCHNAME);
		employeeCreationPage.clickReset();
		Assert.assertTrue(employeeCreationPage.isEmpNameEmpty());
	}

	@Test(priority = 16, groups = { "employee", "cancel" })
	public void employeeCreationCancel() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployeeButton();
		employeeDetailsPage = employeeCreationPage.clickCancel();
		Assert.assertTrue(employeeDetailsPage.isNewEmployeeButtonDisplayed());
	}

	@AfterClass(groups = { "role", "branch", "employee", "create", "reset", "cancel", "valid", "invlaid", "duplicate" })
	public void logoutAndClose() {
		adminHomePage.clickLogout();
		closeBrowser();
	}

}
