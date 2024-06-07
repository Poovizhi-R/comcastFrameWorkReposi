package practiceTestng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.comcast.crm.baseUtility.BaseTest;
@Listeners(Com.comcast.crm.listeners.ListImpClass.class)
public class SampleInvoiceTest extends BaseTest{
@Test
public void createInvoiceTest() {
	System.out.println("Execute createInvoiceTest ");
	String acttitle=driver.getTitle();
	Assert.assertEquals(acttitle, "login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
@Test
public void createInvoiceWithContactTest() {
	System.out.println("Execute createInvoiceWithContactTest ");
	System.out.println();
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
}
