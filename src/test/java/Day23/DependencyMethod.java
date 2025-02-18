package Day23;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethod {

	@Test(priority=1)   
	void openapp()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=2 ,dependsOnMethods= {"openapp"})   			//dependency on this method
	void login()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=3,dependsOnMethods= {"login"})
	void search()
	{
		Assert.assertTrue(false);
	}
		
	@Test(priority=4,dependsOnMethods= {"login","search"})		  //multiple dependency
	void advsearch()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=5 , dependsOnMethods= {"login"})
	void logout() 
	{
		Assert.assertTrue(true);
	}
	
	
	
	
	
	
	
}
