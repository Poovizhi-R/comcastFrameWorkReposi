package PracticehomeTest;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class HomePageVerificationTest {
@Test
public void homePageTest(Method mtd) {
	System.out.println(mtd.getName()+"Test start");
	String expectedpage="Home page";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
	String actualtitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	/*if(actualtitle.trim().equals(expectedpage)) {
		System.out.println("verified--pass");
	}
	else {
		System.out.println("not verified--fail");
	}*/
	//hardassert
	Assert.assertEquals(actualtitle, expectedpage);
	driver.close();
	System.out.println(mtd.getName()+"Test end");
}
@Test
public void verifyLogoHomePageTest(Method mtd) {
	System.out.println(mtd.getName()+"Test start");
	String expectedpage="Home";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
	boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	/*if(status) {
		System.out.println("logo is verified--pass");
	}
	else {
		System.out.println("logo is not verified--fail");
	}*/
	//hardassert
	Assert.assertTrue(status);
	driver.close();
	System.out.println(mtd.getName()+"Test end");
	}
}