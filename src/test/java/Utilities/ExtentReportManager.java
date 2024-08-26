package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
	String repName;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	 public void onStart(ITestContext testContext) 
	 {
		 SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Date dt=new Date();
		 String currentdatetimestamp=df.format(dt);
		 
		 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 repName= "Test-Report-" +timeStamp+ ".html";
		 sparkReporter =new ExtentSparkReporter(".\\Reports\\"+repName);
		 
		 
		 sparkReporter.config().setDocumentTitle("Automation test report of TutorialsNinja");
		 sparkReporter.config().setReportName("Functional testing of TutorialsNinja");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 
		 extent.setSystemInfo("Application", "TutorialsNinja");
		 extent.setSystemInfo("Module","Admin");
		 extent.setSystemInfo("SubModule","Customers");
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("UserName", System.getProperty("user.name"));
		 
		 String os=testContext.getCurrentXmlTest().getParameter("os");
		 extent.setSystemInfo("Operating System", os);
		 
		 String browser=testContext.getCurrentXmlTest().getParameter("browser"); 
		 extent.setSystemInfo("Browser", browser);
		 
		 List<String>includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		 if(!includedGroups.isEmpty())
		 {
			 extent.setSystemInfo("Groups",includedGroups.toString());
		 }
	 }
	 
	 
	 public void onTestSuccess(ITestResult result)
	  {
		 test=extent.createTest(result.getTestClass().getName());//creates a new entry inthe report
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.PASS,result.getName()+"Got Successfully exceuted");//update status pass/fail/skipped
	  }
	 
	 public void onTestFailure(ITestResult result)
	  {
		 test=extent.createTest(result.getTestClass().getName());//creates a new entry inthe report
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.FAIL,result.getName()+"testCase is Failed is:");//update status pass/fail/skipped  
		 test.log(Status.INFO,result.getThrowable().getMessage());
		 
		 try
		 {
			 String imgPath=new BaseClass().captureScreen(result.getName());
			 test.addScreenCaptureFromPath(imgPath);
		 }
		 catch(IOException e1)
		 {
			e1.printStackTrace(); 
		 }
	  }
	 
	 public void onTestSkipped(ITestResult result)
	  {
		 test=extent.createTest(result.getTestClass().getName());//creates a new entry inthe report
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP,result.getName()+"testCase is skipped is:");//update status pass/fail/skipped
		 test.log(Status.INFO,result.getThrowable().getMessage());
	  }
	 
	  public void onFinish(ITestContext context)
	  {
		  extent.flush();
		  
		  String pathofExtentReport=System.getProperty("user.dir")+".\\Reports\\"+repName;
		  File extentReport=new File(pathofExtentReport);
		  try
		  {
			  Desktop.getDesktop().browse(extentReport.toURI());
		  }
		  catch(IOException e)
		  {
			  e.printStackTrace();
		  }
	  }
	  

}
