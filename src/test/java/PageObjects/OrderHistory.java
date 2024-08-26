package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistory extends BasePage{

	public OrderHistory(WebDriver driver) 
	{
		super(driver);

	}

	//locators
	@FindBy(xpath="//a[normalize-space()='View your order history']")
	WebElement btnHistory;
	
	@FindBy(xpath="//h1[normalize-space()='Order History']")
	WebElement orderMsg;
	
	
	public void verifyOrderHistory()
	{
		btnHistory.click();
	}
	public boolean isOrderHistoryExists()
	{
		try
		{
			return (orderMsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
