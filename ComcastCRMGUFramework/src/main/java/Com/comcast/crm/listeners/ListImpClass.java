package Com.comcast.crm.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.comcast.crm.baseUtility.BaseTest;
import Com.comcast.crm.generic.FileUtility.FileUtility;
import Com.comcast.crm.generic.webdriver.utility.UtilityClassObject;

public class ListImpClass implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
	System.out.println("report configuration");
	String time=new Date().toString().replace(" ", "_").replace(":", "_");
	//spark report configuration
	ExtentSparkReporter spark=new ExtentSparkReporter("./advancereport/report"+time+".html");
	spark.config().setDocumentTitle("CRM Test suit results");
	spark.config().setReportName("CRM Report");
	spark.config().setTheme(Theme.DARK);

	//add environment information & create test
report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("os", "windows-10");
	report.setSystemInfo("BROWSER", "CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
		report.flush();//store the result
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====="+result.getMethod().getMethodName()+"====start===");
		 test= report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"====Started===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====="+result.getMethod().getMethodName()+"====end===");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====Completed===");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname=result.getMethod().getMethodName();
		//EventFiringWebDriver edriver = new EventFiringWebDriver(BaseTest.sdriver);
		
		TakesScreenshot eDriver=(TakesScreenshot) BaseTest.sdriver;
		String filepath=eDriver.getScreenshotAs(OutputType.BASE64);
			
			String time=new Date().toString().replace(" ", "_").replace(":", "_");
			
			test.addScreenCaptureFromBase64String(filepath, testname+"_"+time);	
			test.log(Status.FAIL, result.getMethod().getMethodName()+"====Failed===");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		
	}

	

}
