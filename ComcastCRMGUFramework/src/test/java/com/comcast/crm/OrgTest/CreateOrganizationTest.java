package com.comcast.crm.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import Com.comcast.crm.generic.FileUtility.ExcellUtility;
import Com.comcast.crm.generic.FileUtility.FileUtility;
import Com.comcast.crm.objrepoUtility.CreateNewOrganizationPage;
import Com.comcast.crm.objrepoUtility.HomePage;
import Com.comcast.crm.objrepoUtility.LoginPage;
import Com.comcast.crm.objrepoUtility.OrganizationInfoPage;
import Com.comcast.crm.objrepoUtility.OrganizationsPage;
import dev.failsafe.Timeout;

public class CreateOrganizationTest {
	
public static void main(String[] args) throws IOException, InterruptedException {
	FileUtility flib=new FileUtility();
	ExcellUtility elib=new ExcellUtility();
	
	//read common data from property file
	String Browser=flib.getDataFromPropertiesFile("browser");
	String Url=flib.getDataFromPropertiesFile("url");
	String UserName=flib.getDataFromPropertiesFile("username");
	String Pwd=flib.getDataFromPropertiesFile("password");
	
	//generate the random number
	
	Random random=new Random();
	int randomnum=random.nextInt(1000);
	
	//read the test script data from Excel file
	String orgname= elib.getDataFromExcel("org", 1, 2)+randomnum;
	WebDriver driver=null;
	
	if(Browser.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else if(Browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	//step1:login to application
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(Url);
	LoginPage lp=new LoginPage(driver);
	
	lp.loginToApp(Url,UserName,Pwd);
	Thread.sleep(2000);
	//step2:navigate to organization module
	HomePage hp=new HomePage(driver);
	hp.getOrglink().click();
	
	//driver.findElement(By.linkText("Organizations")).click();
	//step3:click on create organization button
	OrganizationsPage op=new OrganizationsPage(driver);
	op.getCreateneworgbtn().click();
	//step4:Enter all the details & create new organization
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createorg(orgname);

	
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actualorgname=oip.getHeadermsg().getText();
	
	//verify orgname information
	
	if(actualorgname.contains(orgname)) {
		System.out.println(orgname +"is verified=pass");
	
	}
	else {
		System.out.println(orgname +"is not verified=fail");	
	}
	//step5:logout
	hp.logout();
	driver.quit();
}
}