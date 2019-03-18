package in.srssprojects.keximbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {

	// branch name
	@FindBy(how = How.ID, using = "txtbName")
	private WebElement branchName;

	// address1
	@FindBy(how = How.ID, using = "txtAdd1")
	private WebElement address1;

	// address2
	@FindBy(how = How.ID, using = "Txtadd2")
	private WebElement address2;

	// address3
	@FindBy(how = How.ID, using = "txtadd3")
	private WebElement address3;

	// area
	@FindBy(how = How.ID, using = "txtArea")
	private WebElement area;

	// zipcode
	@FindBy(how = How.ID, using = "txtZip")
	private WebElement zipCode;
	// country
	@FindBy(how = How.ID, using = "lst_counrtyU")
	private WebElement country;
	// state
	@FindBy(how = How.ID, using = "lst_stateI")
	private WebElement state;
	// state

	// city
	@FindBy(how = How.ID, using = "lst_cityI")
	private WebElement city;

	// submit
	@FindBy(how = How.ID, using = "btn_insert")
	private WebElement submit;

	// reset
	@FindBy(how = How.ID, using = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(how = How.ID, using = "Btn_cancel")
	private WebElement cancel;

	WebDriver driver;
	JavascriptExecutor js;

	public BranchCreationPage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	// fill branchname
	public void fillBranchName(String branchName) {
		this.branchName.sendKeys(branchName);
	}

	// fill address1
	public void fillAddress1(String address1) {
		this.address1.sendKeys(address1);
	}

	// fill address2
	public void fillAddress2(String address2) {
		this.address2.sendKeys(address2);
	}

	// fill address3
	public void fillAddress3(String address3) {
		this.address3.sendKeys(address3);
	}

	// fill area
	public void fillArea(String area) {
		this.area.sendKeys(area);
	}

	// fill zipCode
	public void fillZipCode(String zipCode) {
		this.zipCode.sendKeys(zipCode);
	}
	// select country
	public void selectCountry(String country) {
		new Select(this.country).selectByVisibleText(country);
	}

	// select state
	public void selectState(String state) {
		new Select(this.state).selectByVisibleText(state);
	}

	// select city
	public void selectCity(String city) {
		new Select(this.city).selectByVisibleText(city);
	}
	// click submit
		public Alert clickSubmit() {
			this.submit.click();
			return this.driver.switchTo().alert();
		}

		// click reset
		public void clickReset() {
			this.reset.click();
		}

		// click cancel
		public RoleDetailsPage clickCancel() {
			this.cancel.click();
			return PageFactory.initElements(driver, RoleDetailsPage.class);
		}
	
	//fill branch creation form
		public void fillBranchCreationForm(String branchName, String address1,String area,String zipCode,String country,String state,String city) {
			this.fillBranchName(branchName);
			this.fillArea(area);
			this.fillAddress1(address1);
			this.fillZipCode(zipCode);
			this.selectCountry(country);
			this.selectState(state);
			this.selectCity(city);
			
		}
}
