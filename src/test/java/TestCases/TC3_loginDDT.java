package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC3_loginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups={"Datadriven"})
	public void verify_login_DDT(String email,String pwd,String exp)
	{
		logger.info("***TC3_loginDDT test case started***");
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
		lp.setEmail(email);
		lp.setPwd(pwd);
		lp.Login();
		
		//my account page
		MyAccountPage map=new MyAccountPage(driver);
		boolean targetPage=map.isMyaccountPageExists();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***Finished TC3_loginDDT***");
		
		
	}
}
