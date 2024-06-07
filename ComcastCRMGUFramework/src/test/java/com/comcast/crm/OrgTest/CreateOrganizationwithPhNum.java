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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.Timeout;

public class CreateOrganizationwithPhNum {
public static void main(String[] args) throws IOException, InterruptedException {
	//read the data from property file
	
	//read commondata from property file
	
	FileInputStream fis =new FileInputStream("./src/test/resource/commondata.properties");
	Properties poj=new Properties();
	poj.load(fis);
	String Browser=poj.getProperty("browser");
	String Url=poj.getProperty("url");
	String UserName=poj.getProperty("username");
	String Pwd=poj.getProperty("password");
	
	//generate the random number
	
	Random random=new Random();
	int randomnum=random.nextInt(1000);
	
	//read the testscriptdata from Excel file
	FileInputStream fis1 =new FileInputStream("./src/test/resource/testscriptdatas.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
	Sheet sheet=wb.getSheet("org");
	Row row=sheet.getRow(7);
	String orgname = row.getCell(2).toString()+randomnum;
	String phonenum = row.getCell(3).toString();
	wb.close();
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
	driver.findElement(By.name("user_name")).sendKeys(UserName);
	Thread.sleep(2000);
	driver.findElement(By.name("user_password")).sendKeys(Pwd);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(2000);
	//step2:navigate to organization module
	driver.findElement(By.linkText("Organizations")).click();
	//step3:click on create organization button
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//step4:Enter all the details & create new organization
	
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	driver.findElement(By.id("phone")).sendKeys(phonenum);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	
	
	
	//verify the phonenumber info expected Result
	
	String actphonenumber=driver.findElement(By.id("dtlview_Phone")).getText();
	if(actphonenumber.equals(phonenum)) {
		System.out.println(phonenum +"information is verified");
	
	}
	else {
		System.out.println(phonenum +"information is not verified");	
	}
	
	//step5:logout
	driver.quit();
}
}