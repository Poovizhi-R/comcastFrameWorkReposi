package com.comcast.crm.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.comcast.crm.baseUtility.BaseTest;
import Com.comcast.crm.objrepoUtility.CreateNewOrganizationPage;
import Com.comcast.crm.objrepoUtility.HomePage;
import Com.comcast.crm.objrepoUtility.LoginPage;
import Com.comcast.crm.objrepoUtility.OrganizationInfoPage;
import Com.comcast.crm.objrepoUtility.OrganizationsPage;

public class CreOrgTest extends BaseTest{
	@Test(groups  ="smoketest")
		//read the data from property file
		
	public void createOrgTest()throws Throwable{
		//testscript data from excel file
		
		String orgname = elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
		//step2: navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		
		//step3:click on create organization button
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateneworgbtn().click();
		//step4: enter all the details and create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createorg(orgname);
		//step5: verify header msg expected result
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actorgname=oip.getHeadermsg().getText();
		if(actorgname.contains(orgname)) {
			System.out.println(orgname+"name is verified pass");
		}
		else {
			System.out.println(orgname+"name is verified fail");
		}	
	}
}