package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.OrderHistory;
import TestBase.BaseClass;

public class TC5_OrderHistory extends BaseClass{
	@Test
	public void verifyOrderHistory()
	{
		logger.info("***TC5 order History started***");
		try
		{
			//homepage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***clicked on My account***");
			hp.clickLogin();
			logger.info("***clicked on Login button***");

			
		//login page
		LoginPage lp=new LoginPage(driver);
		logger.info("**Started login ***");
		lp.setEmail(p.getProperty("email"));
		logger.info("**Entered email***");
		lp.setPwd(p.getProperty("password"));
		logger.info("**Entered password***");
		lp.Login();
		logger.info("**clicked login button ***");
		
		//orderHistory
		OrderHistory oh=new OrderHistory(driver);
		oh.verifyOrderHistory();
		logger.info("**verifying order history***");
		oh.isOrderHistoryExists();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**Finished TC5_OrderHistory ***");
	}

}
