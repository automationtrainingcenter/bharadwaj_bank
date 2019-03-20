package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EmployeeDetailsPage {
	WebDriver driver;
	// new employee button
	@FindBy(how = How.ID, using = "BtnNew")
	private WebElement newEmployee;

	// create constructor
	public EmployeeDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on role button
	public EmployeeCreationPage clickNewEmployeeButton() {
		this.newEmployee.click();
		return PageFactory.initElements(driver, EmployeeCreationPage.class);
	}

	// verify role details page by validating visibility of new role button
	public boolean isNewEmployeeButtonDisplayed() {
		return this.newEmployee.isDisplayed();
	}

}
