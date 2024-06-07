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

public class CreateOrganizationwithIndustriesTest {
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
	
	//generate the ramdom number
	
	Random random=new Random();
	int randomnum=random.nextInt(1000);
	
	//read the testscriptdata from Excel file
	FileInputStream fis1 =new FileInputStream("./src/test/resource/testscriptdatas.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
	Sheet sheet=wb.getSheet("org");
	Row row=sheet.getRow(4);
	String orgname = row.getCell(2).toString()+randomnum;
	String industry = row.getCell(3).toString();
	String type = row.getCell(4).toString();
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
	
	WebElement indsel=driver.findElement(By.name("industry"));
	Select sell=new Select(indsel);
	sell.selectByVisibleText(industry);
	
	WebElement typesel=driver.findElement(By.name("accounttype"));
	Select sell2=new Select(typesel);
	sell2.selectByVisibleText(type);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	
	//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	//driver.findElement(By.linkText("Sign Out")).click();
	
	//verify the dropdown industry and type info
	
	String actindustry=driver.findElement(By.id("dtlview_Industry")).getText();
	if(actindustry.equals(industry)) {
		System.out.println(industry +"information is verified");
	
	}
	else {
		System.out.println(industry +"information is not verified");	
	}
	String acttype=driver.findElement(By.id("dtlview_Type")).getText();
	if(acttype.equals(type)) {
		System.out.println(type +"information is verified");
	
	}
	else {
		System.out.println(type+"information is not verified");	
	}
	//step5:logout
	driver.quit();
}
}