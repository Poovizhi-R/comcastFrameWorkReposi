package practicetest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.comcast.crm.generic.FileUtility.ExcellUtility;

public class GetProductInfoTest {
@Test(dataProvider = "getData")
public void getProductInfoTest(String brandname,String productname) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in");
	//search product info
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	//capture product info
	String x="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
}
@DataProvider
public Object[][] getData() throws EncryptedDocumentException, IOException{
	ExcellUtility elib=new ExcellUtility();
	int rowcount=elib.getRowCount("product");
	
	Object[][] objarr=new Object[rowcount][2];
	for(int i=0;i<rowcount;i++) {
		
	
	objarr[i][0]=elib.getDataFromExcel("product",i+1,0);
	objarr[i][1]=elib.getDataFromExcel("product",i+1,1);
	}
	return objarr;
}
}
