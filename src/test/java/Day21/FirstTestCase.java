package Day21;

import org.testng.annotations.Test;

/* 
1) open app
2) login
3) logout

*/
public class FirstTestCase 
{
	@Test(priority=1)
	
	void logout()
	{
		System.out.println("logout from application...........");
	}
	
	@Test(priority=-1)
	void openapp()
	{
		System.out.println("opening application.........");
	}
	
	@Test(priority=0)
	void login()
	{
		System.out.println("login to application.......");
	}
	
	
	
	
	
	
	
}
