package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass extends GenericHelper{
	public WebDriver driver;

	
	public void launchBrowser(String browserName, String url) {
		String os = System.getProperty("os.name").toLowerCase();
		if (browserName.equalsIgnoreCase("chrome") && os.contains("win") ) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox") && os.contains("win")) {
			System.setProperty("webdriver.gecko.driver",getFilePath("drivers", "gekcodriver.exe"));
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "gekcodriver")); 
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void closeBrowser() {
		sleep(3000);
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}
	
	public boolean validataAlertText(String expectedText, String actualText) {
		return actualText.toLowerCase().contains(expectedText.toLowerCase());
	}
	
}
