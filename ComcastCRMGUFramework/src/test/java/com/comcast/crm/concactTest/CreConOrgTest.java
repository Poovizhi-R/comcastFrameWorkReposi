package com.comcast.crm.concactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Com.comcast.crm.baseUtility.BaseTest;
import Com.comcast.crm.objrepoUtility.ContactPage;
import Com.comcast.crm.objrepoUtility.CreateNewContactPage;
import Com.comcast.crm.objrepoUtility.CreateNewOrganizationPage;
import Com.comcast.crm.objrepoUtility.HomePage;
import Com.comcast.crm.objrepoUtility.OrganizationsPage;

public class CreConOrgTest extends BaseTest {
	@Test
	public void createcontactOrg() throws EncryptedDocumentException, IOException {
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
