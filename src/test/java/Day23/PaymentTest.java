package Day23;

import org.testng.annotations.Test;

public class PaymentTest {

	@Test(priority=1 ,groups = {"regression","sanity","functional"})   //give extra name in xml to run only two methods
	void paymentinRupees()
	{
		System.out.println("payment in rupees");
	}
	
	@Test(priority=2,groups = {"regression", "sanity" ,"functional"})
	void paymentinDollers()
	{
		System.out.println("payment in Dollers");
	}
	
	
	
	
}
