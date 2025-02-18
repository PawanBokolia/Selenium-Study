package Day23;

import org.testng.annotations.Test;

public class LoginTests {

	@Test(priority=1, groups = {"sanity"})
	void loginbyEmail()
	{
		System.out.println("this is login by Email");
	}
	
	
	
	@Test(priority=2, groups = {"sanity"})
	void loginbyFacebook()
	{
		System.out.println("this is login by facebook");
	}
	
	
	@Test(priority=3, groups = {"sanity"})
	void loginbytwitter()
	{
		System.out.println("this is login by twitter");
	}
	
	
	
}
