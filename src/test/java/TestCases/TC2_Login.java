package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC2_Login extends BaseClass{
	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("***Started login testcase***");
		try
		{
			//homepage
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***clicked on My account***");
			hp.clickLogin();
			logger.info("***clicked on Login button***");
			
			//login
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPwd(p.getProperty("password"));
			lp.Login();
			
			//my account
			MyAccountPage map=new MyAccountPage(driver);
			boolean targetPage=map.isMyaccountPageExists();
			
			Assert.assertTrue(targetPage);
			
		}
		catch(Exception e)
		{
			logger.info("***Login Test case failed***");
			Assert.fail();
		}
		
	}
	
}
