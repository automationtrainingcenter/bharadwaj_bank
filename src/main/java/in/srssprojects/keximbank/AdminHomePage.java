package in.srssprojects.keximbank;
//this class implementing using page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	WebDriver driver;

	// branches
	@FindBy(how = How.XPATH, using = "")
	private WebElement branches;

	// roles
	@FindBy(how = How.XPATH, using = "")
	private WebElement roles;

	// employees
	@FindBy(how = How.XPATH, using = "")
	private WebElement employees;

	// home
	@FindBy(how = How.XPATH, using = "")
	private WebElement home;

	// logout
	@FindBy(how = How.XPATH, using = "")
	private WebElement logout;
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on branches
	public void clickBranches() {
		this.branches.click();
	}

	// click on roles
	public void clickRoles() {
		this.roles.click();
	}

	// click on employees
	public void clickEmployees() {
		this.employees.click();
	}

	// click on home
	public void clickHome() {
		this.home.click();
	}

	// click on logout
	public void clickLogout() {
		this.logout.click();
	}

}
