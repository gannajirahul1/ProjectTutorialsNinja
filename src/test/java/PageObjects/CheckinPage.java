package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckinPage extends BasePage {
	//constructors
	
	public CheckinPage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtName;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iMac')]")
	WebElement btnMac;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddtoCart;
	
	
	

	
	//actions
	
	public void setName(String name)
	{
		txtName.sendKeys(name);
	}
	public void clickSearch()
	{
		btnSearch.click();
	}
	public void clickMac()
	{
		btnMac.click();
	}
	public void clickToCart()
	{
		btnAddtoCart.click();
	}
}
