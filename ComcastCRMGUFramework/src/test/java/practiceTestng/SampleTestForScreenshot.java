package practiceTestng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot {
	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		//step1: create an obj to eventfiring webdriver
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		//step1: use getscreenshotas method to get file type of screenshot
		File scrfile=edriver.getScreenshotAs(OutputType.FILE);
	//	File perfile=new File("./screenshot/amazon.png");
		
		//Step3:store screenshot in local driver
		FileUtils.copyFile(scrfile, new File("./screenshot/amazon.png"));
		
	}
	

}
