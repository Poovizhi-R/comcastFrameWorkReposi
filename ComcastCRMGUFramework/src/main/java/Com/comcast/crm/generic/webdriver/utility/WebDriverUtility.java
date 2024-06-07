package Com.comcast.crm.generic.webdriver.utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
public void waitforElementPresent(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void switchtoTabonUrl(WebDriver driver, String partialUrl) {
	Set<String> set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext()) {
		String windowID=it.next();
		driver.switchTo().window(windowID);
		String acturl=driver.getCurrentUrl();
		if(acturl.contains(partialUrl)) {
			break;
		}
	}
}
}
