package com.comcast.crm.concactTest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Com.comcast.crm.baseUtility.BaseTest;
import Com.comcast.crm.generic.FileUtility.ExcellUtility;
import Com.comcast.crm.generic.FileUtility.FileUtility;
import Com.comcast.crm.generic.webdriver.utility.JavaUtility;
import Com.comcast.crm.listeners.ListImpClass;
import Com.comcast.crm.objrepoUtility.ContactPage;
import Com.comcast.crm.objrepoUtility.CreateNewContactPage;
import Com.comcast.crm.objrepoUtility.CreateNewOrganizationPage;
import Com.comcast.crm.objrepoUtility.HomePage;
import Com.comcast.crm.objrepoUtility.OrganizationsPage;
@Listeners(Com.comcast.crm.listeners.ListImpClass.class)
public class CreateContactTest extends BaseTest{
@Test(groups = "smoketest")
		public void createContactTest() throws EncryptedDocumentException, IOException {
	ListImpClass.test.log(Status.INFO, "read data from excelsheet");
			//read the test script data from Excel file
		String lastName=elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
			//step2:navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		//step3:click on create contact button
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn();
		//step4:Enter all the details & create new organization
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createcontact(lastName);
		//verify the header phone number info expected Result
		String actheader=cp.getHeadermsg().getText();
				//driver.findElement(By.className("dvHeaderText")).getText();
		boolean status=actheader.contains(lastName);
		Assert.assertEquals(status, true);
		String actlastname=driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert assertobj=new SoftAssert();
		assertobj.assertEquals(actlastname, true);
		}
@Test(groups = "regressiontest")
public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {
	//step1:read the test script data from Excel file
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
		//verify start date and end date
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
@Test(groups = "regressiontest")
	public void createContactWithorgTest() throws EncryptedDocumentException, IOException {
		String orgname=elib.getDataFromExcel("contact", 7, 2)+jlib.getRandomNumber();
		String contactlastname=elib.getDataFromExcel("contact", 7, 3)+jlib.getRandomNumber();
		//step2:nav to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		//step3:click on create organization button
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateneworgbtn().click();
		//step4:enter all the details & create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createorg(orgname);
		//verify header orgname info expected result
		String actualorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actualorgname.trim().equals(orgname)){
			System.out.println(orgname +"is created=pass");
		
		}
		else {
			System.out.println(orgname +"is not created=fail");	
		}
		//step5:navigate to contact module
		hp.getContactlink().click();
		//step6: click on "create contact" button
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		//step7: enter all the details & create new contact
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createContactWithOrg(contactlastname, actualorgname);
		//verify header orgname info Expected result
		String aclorgname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(aclorgname);
		if(aclorgname.trim().equals(orgname)) {
			System.out.println(orgname +"is created=pass");
		
		}
		else {
			System.out.println(orgname +"is not created=fail");	
		}
}
}	
