package Com.comcast.crm.baseUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.comcast.crm.generic.FileUtility.ExcellUtility;
import Com.comcast.crm.generic.FileUtility.FileUtility;
import Com.comcast.crm.generic.webdriver.utility.JavaUtility;
import Com.comcast.crm.objrepoUtility.HomePage;
import Com.comcast.crm.objrepoUtility.LoginPage;

public class BaseTest {
	/*create object*/
public FileUtility flib=new FileUtility();
public ExcellUtility elib=new ExcellUtility();
public JavaUtility jlib=new JavaUtility();
public WebDriver driver=null;
public static WebDriver sdriver=null;


@BeforeSuite
public void configBs() {
	System.out.println("Connect to DB & Report config");
	}

//@Parameters("browser")
@BeforeClass
//public void configBC(String browser)
public void configBC() throws IOException {
	System.out.println("launch the browser");
	String Browser=flib.getDataFromPropertiesFile("browser");
			//browser;
		
	if(Browser.equals("chrome")) {
		driver=new ChromeDriver();
	}else if(Browser.equals("firefox")) {
		driver=new FirefoxDriver();
	}else
	{
		driver=new EdgeDriver();
	}
	sdriver=driver;//real driver after launching i am trying to store session id in sdriver var
}
@BeforeMethod
public void configBM() throws IOException {
	System.out.println("login");

	
	String Url=flib.getDataFromPropertiesFile("url");
	String UserName=flib.getDataFromPropertiesFile("username");
	String Pwd=flib.getDataFromPropertiesFile("password");
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(Url, UserName, Pwd);
}

@AfterMethod
public void configAM() {
	System.out.println("logout");
	HomePage hp=new HomePage(driver);
	hp.logout();
}
@AfterClass
public void configAC() {
	System.out.println("Close the browser");
	driver.quit();
}
@AfterSuite
public void configAS() {
	System.out.println("Close to DB & Report backup");
	//report.flush();
}
}


