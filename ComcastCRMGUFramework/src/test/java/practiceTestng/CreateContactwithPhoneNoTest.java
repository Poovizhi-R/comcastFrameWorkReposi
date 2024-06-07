package practiceTestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactwithPhoneNoTest {
@Test(dataProvider = "getData")
public void createContactTest(String firstname,String lastname,long phonenum) {
	System.out.println(firstname+","+lastname+","+phonenum);
}
	@DataProvider
	public Object[][] getData(){
		Object[][] objarr=new Object[3][3];
		objarr[0][0]="poovi";
		objarr[0][1]="hr";
		objarr[0][2]=9789664385l;
		objarr[1][0]="sam";
		objarr[1][1]="hd";
		objarr[1][2]=9789664386l;
		objarr[2][0]="poo";
		objarr[2][1]="ram";
		objarr[2][2]=9789664387l;
		return objarr;
	}
	}


