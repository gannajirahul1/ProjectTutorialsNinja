package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import TestBase.BaseClass;

public class TC1_Register extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void VerifyRegister()
	{
		logger.info("***Starting TC1_Register Test***");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***Clicked on My account***");
		
		hp.clickRegister();
		logger.info("***Clicked on Register***");
		
		RegistrationPage regPage=new RegistrationPage(driver);
		logger.info("***Entering user details***");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setPhone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regPage.setPassword(password);
		regPage.setConPwd(password);
		
		regPage.clickCheckBox();
		logger.info("***Clicked on checkbox***");
		regPage.clickSubmit();
		logger.info("***Clicked on submit***");
		
		String confmsg=regPage.getConfirmationMsg();
		//Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed.....");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***finished registration.....***");
}
	
}