package Com.comcast.crm.objrepoUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class CreateNewOrganizationPage {
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(name = "accountname")
private WebElement orgnameedt;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;
@FindBy(name = "industry")
private WebElement industrydb;
public WebElement getOrgnameedt() {
	return orgnameedt;
}
public WebElement getSavebtn() {
	return savebtn;
}
public void createorg(String orgName) {
	orgnameedt.sendKeys(orgName);
	savebtn.click();
}
public void createorg(String orgName,String industry) {
	orgnameedt.sendKeys(orgName);
	Select sel=new Select(industrydb);
	sel.selectByVisibleText(industry);
	savebtn.click();
}
}
