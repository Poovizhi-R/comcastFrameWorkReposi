package com.comcast.crm.concactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Com.comcast.crm.baseUtility.BaseTest;
import Com.comcast.crm.objrepoUtility.ContactPage;
import Com.comcast.crm.objrepoUtility.CreateNewContactPage;
import Com.comcast.crm.objrepoUtility.HomePage;





public class CreateContactWithSupportDate extends BaseTest {
	@Test
	
	public void createcontactwithdate() throws EncryptedDocumentException, IOException {
		//step1:read the testscriptdata from Excel file
		String lastname=elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();
		//step2:navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		//step3:click on create organization button
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		//step4:Enter all the details & create new contact
		String enddate=jlib.getSystemDateyyyyDDMM();
		String startdate=jlib.getRequiredDateYYYYDDMM(30);
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createcontactwithSupportDate(lastname, startdate, enddate);
	//verify startdate and enddate
		String actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartdate.equals(startdate)) {
			System.out.println(startdate +"information is verified");
			}
		else {
			System.out.println(startdate +"information is not verified");	
		}
		String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actenddate.equals(enddate)) {
			System.out.println(enddate +"information is verified");
		
		}
		else {
			System.out.println(enddate +"information is not verified");	
		}
		}
	}

