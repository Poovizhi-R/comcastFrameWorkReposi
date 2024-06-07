package com.comcast.crm.concactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;



import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {

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
			Sheet sheet=wb.getSheet("contact");
			Row row=sheet.getRow(7);
			String orgname = row.getCell(2).toString()+randomnum;
			String contactlastname = row.getCell(3).toString();
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
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			Thread.sleep(2000);
			//verify header orgname info expected result
			String actualorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actualorgname.trim().equals(orgname)){
				System.out.println(orgname +"is created=pass");
			
			}
			else {
				System.out.println(orgname +"is not created=fail");	
			}
				
			
		
			//step5:navigate to contact module
			driver.findElement(By.linkText("Contacts")).click();
			//step6:click on create contact button
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			//step7:Enter all the details & create new organization
			
			driver.findElement(By.name("lastname")).sendKeys(contactlastname);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		//switch to child window
			
		Set<String> set=driver.getWindowHandles();
	Iterator<String>it=set.iterator();
	
	while(it.hasNext()) {
		String windowId=it.next();
		driver.switchTo().window(windowId);
		
		String actualurl=driver.getCurrentUrl();
		if(actualurl.contains("module=Accounts")) {
			System.out.println(windowId);
			break; 
		}
	}

driver.findElement(By.name("search_text")).sendKeys(orgname);
driver.findElement(By.name("search")).click();
driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
//switch to parent window

		Set<String> set1=driver.getWindowHandles();
	Iterator<String>it1=set1.iterator();
	while(it1.hasNext()) {
		System.out.println(it1);
		String windowId=it1.next();
		driver.switchTo().window(windowId);
		String actualurl=driver.getCurrentUrl();
		if(actualurl.contains("Contacts&action")) {
			break; 
		}
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
			//verify the header phonenumber info expected Result
			
	//verify header msg expected result
	String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(contactlastname)) {
		System.out.println(contactlastname +"is created=pass");
	
	}
	else {
		System.out.println(orgname +"is not created=fail");	
	}
	//verify header orgname info Expected result
	String aclorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(aclorgname);
	if(aclorgname.trim().equals(orgname)) {
		System.out.println(orgname +"is created=pass");
	
	}
	else {
		System.out.println(orgname +"is not created=fail");	
	}
			driver.quit();
	}

}
