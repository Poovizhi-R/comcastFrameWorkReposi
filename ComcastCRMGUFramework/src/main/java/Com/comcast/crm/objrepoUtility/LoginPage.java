package Com.comcast.crm.objrepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.comcast.crm.generic.webdriver.utility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//rule1: create a separate java class for each page
	//rule2: obj creation
	@FindBy(name = "user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginButton;
	//rule3:obj initialization
	//rule4: obj encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	//rule5: business method(provide action)
	public void loginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginButton.click();
	}
	
}
