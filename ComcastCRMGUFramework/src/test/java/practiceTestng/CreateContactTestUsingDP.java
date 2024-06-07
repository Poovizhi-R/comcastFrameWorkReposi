package practiceTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestUsingDP {
@Test(dataProvider = "getData")
public void createContactTest(String firstname,String lastname) {
	System.out.println("FirstName:"+firstname+", "+"LastName:"+lastname);
}
@DataProvider
public Object[][] getData(){
	Object[][] objarr=new Object[3][2];
	objarr[0][0]="poovi";
	objarr[0][1]="hr";
	objarr[1][0]="sam";
	objarr[1][1]="hd";
	objarr[2][0]="poo";
	objarr[2][1]="ram";
	return objarr;
}
}
