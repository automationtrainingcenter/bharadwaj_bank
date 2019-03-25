package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass extends GenericHelper {
	public WebDriver driver;

	public void launchBrowser(String browserName, String url) {
		String os = System.getProperty("os.name").toLowerCase();
		if (browserName.equalsIgnoreCase("chrome") && os.contains("win")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox") && os.contains("win")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getFilePath("drivers", "chromedriver"));
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getFilePath("drivers", "geckodriver"));
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
	}

	// launch browser method for grid
	public void launchBrowser(String browserName, String url, String nodeUrl, String os) {
		// create DesiredCapabilities class object
		DesiredCapabilities caps = new DesiredCapabilities();
		if (os.equals("windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (os.equals("mac")) {
			caps.setPlatform(Platform.MAC);
		}
		if (os.equals("linux")) {
			caps.setPlatform(Platform.LINUX);
		}
		if (browserName.equals("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browserName.equals("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
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
