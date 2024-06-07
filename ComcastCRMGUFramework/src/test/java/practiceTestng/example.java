package practiceTestng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Com.comcast.crm.baseUtility.BaseTest;
//@Listeners(Com.comcast.crm.listeners.ListImpClass.class)
public class example extends BaseTest {
	
	@Test
	public void Name() {
		
		driver.get("www.google.com");
		System.out.println("working");
		
	}

}
