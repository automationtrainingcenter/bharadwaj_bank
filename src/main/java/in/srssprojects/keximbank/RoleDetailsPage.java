package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RoleDetailsPage {
	WebDriver driver;
	//new role button
	@FindBy(how = How.ID, using = "btnRoles")
	private WebElement newRole;
	
	//create constructor
	public RoleDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//click on role button
	public RoleCreationPage clickNewRoleButton() {
		this.newRole.click();
		return PageFactory.initElements(driver, RoleCreationPage.class);
	}
	
	//verify role details page by validating visibility of new role button
	public boolean isNewRoleButtonDisplayed() {
		return this.newRole.isDisplayed();
	}
	

}
