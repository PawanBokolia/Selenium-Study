package Day22pack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	
	@Test
	void pqr()
	{
		System.out.println("this is abc from c3");
	}
	
	@AfterSuite	
	void as()
	{
		System.out.println("this is After suite test method");
	}
	
	
	@BeforeSuite	
	void bs()
	{
		System.out.println("this is Before suite test method");
	}
	
}
