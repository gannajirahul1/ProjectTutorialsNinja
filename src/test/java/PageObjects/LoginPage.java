package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
//	WebDriver driver;
	
	//constructors
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	//locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement buttonLogin; 
	
	//actions
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPwd(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	public void Login()
	{
		buttonLogin.click();
	}
	
}
