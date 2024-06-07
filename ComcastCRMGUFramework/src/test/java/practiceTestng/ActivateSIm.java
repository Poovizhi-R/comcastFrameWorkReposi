package practiceTestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateSIm {
@Test(retryAnalyzer=Com.comcast.crm.listeners.RetryListenerImp.class)
public void activateSimTest() {
	System.out.println("execute create Invoice Test");
	Assert.assertEquals("", "login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
}
}
