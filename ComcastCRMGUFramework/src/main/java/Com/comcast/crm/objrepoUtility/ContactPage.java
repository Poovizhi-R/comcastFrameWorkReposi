package Com.comcast.crm.objrepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headermsg;
	
public WebElement getHeadermsg() {
		return headermsg;
	}
@FindBy(linkText = "Contacts")
private WebElement contactslink;
@FindBy(xpath = "//img[@title='Create Contact...']")
private WebElement createcontactbtn;
@FindBy(name="lastname")
private WebElement lastnameedt;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;
public WebElement getCreatecontactbtn() {
	return createcontactbtn;
}

}


