package practiceTestng;

import org.testng.annotations.Test;

public class OrderTest {
@Test(invocationCount = 10)
public void createOrderTest() { 
	System.out.println("Excute createordertest-->123");
	String str=null;
	System.out.println(str.equals("123"));
}
@Test(dependsOnMethods = "createOrderTest")
public void billingOrderTest() {
	System.out.println("Excute billingordertest-->123");
}
@Test(enabled = false)
public void cartTest() {
	System.out.println("cart");
}
}
