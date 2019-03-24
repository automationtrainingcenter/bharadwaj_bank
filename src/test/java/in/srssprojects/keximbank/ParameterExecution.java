package in.srssprojects.keximbank;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterExecution extends TestExecution {
	@BeforeClass(groups = { "role", "branch", "employee", "create", "reset", "cancel", "valid", "invlaid",
			"duplicate" })
	@Parameters({"brName", "url"})
	public void testBrowserLaunch(String browserName, String url) {
		launchBrowser(browserName, url);
		bankHomePage = new BankHomePage(driver);
		Assert.assertTrue(bankHomePage.verifyBankHomePage());
	}
}
