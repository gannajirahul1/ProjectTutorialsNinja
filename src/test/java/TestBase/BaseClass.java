package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
	
	public static WebDriver driver;
	public Logger logger;//log4j
	public Properties p;
	
	@BeforeClass(groups={"Sanity","Regression","Master","Datadriven"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		//loading config properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();
						break;
		case "edge":driver=new EdgeDriver();
						break;
		case "firefox":driver=new FirefoxDriver();
						break;
		default:System.out.println("Invalid browser name");
						return;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("URL1"));
		driver.manage().window().maximize();
	
	}
	
	@AfterClass(groups={"Sanity","Regression","Master","Datadriven"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumber()
	{
		String generatedNum=RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}
	public String randomAlphaNumeric()
	{
		String generatedNum=RandomStringUtils.randomNumeric(3);	
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return (generatedNum+"@"+generatedString);
	}

	public String captureScreen(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilepath=System.getProperty("user.dir")+"\\ScreenShots\\"+tname+ "_" +timeStamp+".png";
		File targetFile=new File(targetFilepath);
		
		sourceFile.renameTo(targetFile);
		return targetFilepath;
	}
	
	
}
