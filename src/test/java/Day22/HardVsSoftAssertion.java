package Day22;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {

	//@Test
	void test_hardassertions() {
		
		System.out.println("testing.........");
		System.out.println("testing.........");
		
		Assert.assertEquals(1, 2);				//Hard Assertion  // in hard assertion - as assertion is fail no more statement will be executed
		
		
		System.out.println("testing.........");
		System.out.println("testing.........");
		
	}
	
	@Test
	void test_softassertion()
	{
		System.out.println("testing.........");
		System.out.println("testing.........");
		
		SoftAssert sa = new SoftAssert();    		//Ever thing is same but for soft assertion need to create object //in soft assertion as assertion fails other statement will also execute 
		sa.assertEquals(1, 2);		
		
		
		System.out.println("testing.........");
		System.out.println("testing.........");
		
		sa.assertAll(); 				  			//mandatory 
		
	}
	
	
	
	
	
	
	
	
}



	