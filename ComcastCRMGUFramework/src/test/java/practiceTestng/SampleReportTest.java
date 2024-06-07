package practiceTestng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.comcast.crm.baseUtility.BaseTest;

public class SampleReportTest extends BaseTest{
	
	@Test

	public void createContact() {
		//just takecare of the log statement
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		//Take Screenshot
		TakesScreenshot edriver=(TakesScreenshot)driver;
		String filepath=edriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test= report.createTest("createContact");
			test.log(Status.INFO,"log to app");	
	test.log(Status.INFO,"nav to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HFFC")) {
		test.log(Status.PASS,"Contact is created--PASS");
	}
	else
	{
		test.addScreenCaptureFromBase64String(filepath, "ErrorFile");	
	}
}
	@Test

	public void createWithOrg() {
		//just takecare of the log statement
		
		ExtentTest test= report.createTest("createWithOrg");
			test.log(Status.INFO,"log to app");	
	test.log(Status.INFO,"nav to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC")) {
		test.log(Status.PASS,"Contact is created--PASS");
	}
	else
	{
		test.log(Status.FAIL,"Contact is not created");	
	}
}
	@Test

	public void createContactWithPhoneNum() {
		//just takecare of the log statement
		
		ExtentTest test= report.createTest("createContactWithPhoneNum");
			test.log(Status.INFO,"log to app");	
	test.log(Status.INFO,"nav to contact page");
	test.log(Status.INFO,"create contact");
	if("HDFC".equals("HDFC")) {
		test.log(Status.PASS,"Contact is created--PASS");
	}
	else
	{
		test.log(Status.FAIL,"Contact is not created");	
	}
}
}
