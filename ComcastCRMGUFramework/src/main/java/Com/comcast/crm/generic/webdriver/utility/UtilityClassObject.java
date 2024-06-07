package Com.comcast.crm.generic.webdriver.utility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest Test) {
	 test.set(Test);
	}
	public static WebDriver getdriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actDriver) {
	 driver.set(actDriver);
	}
	
}
