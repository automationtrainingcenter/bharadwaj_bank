package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BankHomePage {
	WebDriver driver;

	// username
	public WebElement username() {
		return driver.findElement(By.id("txtuId"));
	}

	// password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}

	// login button
	public WebElement login() {
		return driver.findElement(By.id("login"));
	}
	
	//constructor of the class
	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// fill user name
	public void fillUserName(String username) {
		this.username().sendKeys(username);
	}

	// fill password
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}

	// click login button
	public void clickLogin() {
		this.login().click();
	}
	
	//verify bank home page is opened after successful launch
	public boolean verifyBankHomePage() {
		return driver.getTitle().equals("KEXIM BANK") && this.login().isDisplayed();
	}

}
