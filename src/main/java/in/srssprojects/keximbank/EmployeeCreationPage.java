package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {

	private WebDriver driver;
	// emp name
	@FindBy(how = How.ID, using = "txtUname")
	private WebElement empName;

	// login password
	@FindBy(how = How.ID, using = "txtLpwd")
	private WebElement loginPassword;

	// role
	@FindBy(how = How.ID, using = "lst_Roles")
	private WebElement role;

	// branch
	@FindBy(how = How.ID, using = "lst_Branch")
	private WebElement branch;

	// submit
	@FindBy(how = How.ID, using = "BtnSubmit")
	private WebElement submit;

	// reset
	@FindBy(how = How.ID, using = "btnreset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "btnCancel")
	private WebElement cancel;

	public EmployeeCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// fill employee name
	public void fillEmployeeName(String empName) {
		this.empName.sendKeys(empName);
	}

	// fill login password
	public void fillLoginPassword(String loginPassword) {
		this.loginPassword.sendKeys(loginPassword);
	}

	// select role type
	public void selectRole(String roleType) {
		new Select(this.role).selectByVisibleText(roleType);
	}

	// select branch
	public void selectBranch(String branchName) {
		new Select(this.branch).selectByVisibleText(branchName);
	}

	// click submit
	public Alert clickSubmit() {
		this.submit.click();
		return driver.switchTo().alert();
	}

	// click reset
	public void clickReset() {
		this.reset.click();
	}

	// click cancel
	public EmployeeDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, EmployeeDetailsPage.class);
	}

	// verify emp name field is empty
	public boolean isEmpNameEmpty() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].value", this.empName).toString().isEmpty();
	}

	// fill employee creation form
	public void fillEmployeeCreationForm(String empName, String loginPassword, String role, String branch) {
		this.fillEmployeeName(empName);
		this.fillLoginPassword(loginPassword);
		this.selectRole(role);
		this.selectBranch(branch);
	}

}
