package practiceTestng;

import org.testng.annotations.Test;

public class ContactTest {
@Test(priority = 1)
public void createContact() {
	System.out.println("execute createcontact with HDFC");
}
@Test(priority = 2)
public void modifyContact() {
	System.out.println(" Execute query insert contact in db--> ICICI");
	System.out.println("execute modifycontact-->ICICI TO ICICI_1");
}
@Test(priority = 3)
public void deleteContact() {
	System.out.println(" Execute query insert contact in db--> UPI");
	System.out.println("execute deletecontact--->UPI");
}
}
