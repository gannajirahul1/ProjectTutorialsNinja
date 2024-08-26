package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
	
	public WebDriver driver;
	//constructors
	public RegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFName;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLName;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtPhone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPwd;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkBox; 
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnSubmit; 
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//actions
	public void setFirstName(String Fname)
	{
		txtFName.sendKeys(Fname);
	}
	public void setLastName(String Lname)
	{
		txtLName.sendKeys(Lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setPhone(String number)
	{
		txtPhone.sendKeys(number);
	}
	public void setPassword(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	public void setConPwd(String conpwd)
	{
		txtconPwd.sendKeys(conpwd);
	}
	public void clickCheckBox()
	{
		checkBox.click();
	}
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	public String getConfirmationMsg()
	{
	try
	{
		return(msgConfirmation.getText());
	}
	catch(Exception e)
	{
		return(e.getMessage());
	}
	}
	
}
