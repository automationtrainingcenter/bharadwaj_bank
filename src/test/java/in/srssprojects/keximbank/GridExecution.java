package in.srssprojects.keximbank;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution {
	@BeforeClass(groups = { "role", "branch", "employee", "create", "reset", "cancel", "valid", "invlaid",
			"duplicate" })
	@Parameters({"brName", "url","nodeURL", "os"})
	public void testBrowserLaunch(String browserName, String url, String nodeUrl, String os) {
		launchBrowser(browserName, url, nodeUrl, os);
		bankHomePage = new BankHomePage(driver);
		Assert.assertTrue(bankHomePage.verifyBankHomePage());
	}
}
