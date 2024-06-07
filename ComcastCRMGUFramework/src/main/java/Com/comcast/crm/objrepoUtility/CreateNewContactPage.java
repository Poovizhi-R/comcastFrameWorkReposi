package Com.comcast.crm.objrepoUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.comcast.crm.generic.webdriver.utility.WebDriverUtility;

public class CreateNewContactPage {
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Contacts")
	private WebElement contactslink;
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontactbtn;
	@FindBy(name = "lastname")
	private WebElement lastnameedt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(name = "support_start_date")
	private WebElement startdateedt;
	@FindBy(name = "support_end_date")
	private WebElement enddateedt;
	@FindBy(xpath = "//input[@name='account_name']")
	private WebElement contactneworgtf;
	@FindBy(name = "search_text")
	private WebElement plussearchorg;
	@FindBy(xpath = "//a[text()='+orgName+']")
	private WebElement dynamicorgname;
	@FindBy(name="search")
	private WebElement searchorgbtn;
	public void createcontact(String lastname) {
		contactslink.click();
		createcontactbtn.click();
		lastnameedt.sendKeys(lastname);
		savebtn.click();
	}
	
	public void createcontactwithSupportDate(String lastname,String startdate,String enddate) {
		contactslink.click();
		createcontactbtn.click();
		lastnameedt.sendKeys(lastname);
		startdateedt.clear();
		startdateedt.sendKeys(startdate);
		enddateedt.clear();
		enddateedt.sendKeys(enddate);
		savebtn.click();
		}
	public void createContactWithOrg(String contactlastname,String orgname) {
		contactslink.click();
		createcontactbtn.click();
		lastnameedt.sendKeys(contactlastname);
		contactneworgtf.click();
		wlib.switchtoTabonUrl(driver, "module=Accounts");
		plussearchorg.sendKeys(orgname);
		searchorgbtn.click();
		driver.findElement(By.linkText(orgname)).click();
		wlib.switchtoTabonUrl(driver, "Contacts&action");
	}
}
