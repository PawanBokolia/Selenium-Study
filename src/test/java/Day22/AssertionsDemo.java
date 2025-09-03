package Day22;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertionsDemo {

	@Test
	void testTitle()
	{
		String exp_title= "Opencart";
		String act_title="asa";
		
		if(exp_title.equals(act_title)) 				//if statement cannot make the test fail so use assertion
		{
			System.out.println("test pass");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("test failed");
			Assert.assertTrue(false);
		}
	
	//	Assert.assertEquals(exp_title, act_title);        
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
