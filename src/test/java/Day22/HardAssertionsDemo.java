package Day22;


import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionsDemo {
	
	@Test
	void test()
	{
		//Assert.assertEquals("xyz", "xyz1");
		//Assert.assertEquals("123", "324");
		//Assert.assertEquals("abc", 123);
		//Assert.assertEquals("123", 123);
		
		//Assert.assertNotEquals(123, 123);   //failed
		//Assert.assertNotEquals(123, 345);   
		
		//Assert.assertTrue(true);
		//Assert.assertTrue(false);
		
		//Assert.assertTrue(1==2);
		//Assert.assertTrue(1==1);
		
		//Assert.assertFalse(1==2);
		//Assert.assertFalse(1==1);
		
		Assert.fail();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
