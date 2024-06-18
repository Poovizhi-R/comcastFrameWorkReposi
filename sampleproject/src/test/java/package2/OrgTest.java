package package2;

import org.testng.annotations.Test;

public class OrgTest {

	@Test
	public void createorgTest() {
		System.out.println("executeorgtest");
		String url=System.getProperty("url");
		String browser=System.getProperty("browser","chrome");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
	}
	@Test
	public void modifyorgTest() {
		System.out.println("executemodifyorgtest");
	}

}
