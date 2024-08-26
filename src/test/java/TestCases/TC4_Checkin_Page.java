package TestCases;

import org.testng.annotations.Test;

import PageObjects.CheckinPage;
import PageObjects.Checkin_SuccessPage;
import TestBase.BaseClass;

public class TC4_Checkin_Page extends BaseClass{
	@Test
	public void orderProduct()
	{
		logger.info("***TC4_order product ***");
		
		CheckinPage cp=new CheckinPage(driver);
		cp.setName("mac");
		logger.info("***enetring values in search***");
		cp.clickSearch();
		logger.info("***clicked on search button***");
		cp.clickMac();
		logger.info("***clicked on Mac button***");
		cp.clickToCart();
		logger.info("***clicked on addTo cart button***");
		
		
		//CheckinSuccess page
		Checkin_SuccessPage csp=new Checkin_SuccessPage(driver);
		csp.isCheckin_SuccessPageExists();
		logger.info("***Successfully got confirmation msg***");
		csp.clickCheckout();
		logger.info("***clicked on Checkout***");
		csp.clickContinue();
		logger.info("***clicked on Continue and entering homepage***");
	}
	

}
