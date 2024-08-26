package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkin_SuccessPage extends BasePage {

	public Checkin_SuccessPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath=("//h2[normalize-space()='My Account']"))
	WebElement successConf;
	
	//checkout
	@FindBy(xpath=("//span[normalize-space()='Checkout']"))
	WebElement btnCheckout;
	
	//continue:after the completion of checkout we are entering to homepage by clicking on homepage
	@FindBy(xpath=("//a[@class='btn btn-primary']"))
	WebElement btnContinue;
	
	
	public boolean isCheckin_SuccessPageExists()
	{
		try
		{
			return(successConf.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickCheckout()
	{
		btnCheckout.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
}
