package in.srssprojects.keximbank;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution{
	@BeforeClass(groups = { "role", "branch", "employee", "create", "reset", "cancel", "valid", "invlaid",
			"duplicate" })
	public void testBrowserLaunch() {
		launchBrowser(readProperty("browserName"), readProperty("url"));
		bankHomePage = new BankHomePage(driver);
		Assert.assertTrue(bankHomePage.verifyBankHomePage());
	}
}
