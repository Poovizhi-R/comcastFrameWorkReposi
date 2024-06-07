package PracticehomeTest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {

public class HomePageVerificationTest {
@Test
public void homePageTest(Method mtd) {
	Reporter.log(mtd.getName()+"Test start");
	Reporter.log(null);
	SoftAssert assertobj=new SoftAssert();
	Reporter.log("Step-1",true);
	Reporter.log("Step-2",true);
	//Assert.assertEquals("home", "home");
	Assert.assertNotEquals("home", "homepage");
	Reporter.log("Step-3",true);
	assertobj.assertEquals("Title","Title-1");
	Reporter.log("Step-4",true);
assertobj.assertAll();
	Reporter.log(mtd.getName()+"Test end");
}
@Test
public void verifyLogoHomePageTest(Method mtd) {
	Reporter.log(mtd.getName()+"Test start");
	SoftAssert assertobj=new SoftAssert();
	Reporter.log("Step-1",true);
	Reporter.log("Step-2",true);
	Assert.assertTrue(true);
	Reporter.log("Step-3",true);
	Reporter.log("Step-4",true); 
	assertobj.assertAll();
	Reporter.log(mtd.getName()+"Test end");
	}
}
}
