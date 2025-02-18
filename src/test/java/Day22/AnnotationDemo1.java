package Day22;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
TC1
------
1) login -----@BeforeMethod
2) search ----@Test
3) logout------@AfterMethod
4) Login-------@BeforeMethod
5) adv search -----@Test
6) logout--------@AfterMethod

*/
public class AnnotationDemo1 {
		
		@BeforeMethod
		void login()
		{
			System.out.println("this is login.....");
		}
	
		@Test(priority=1)
		void search()
		{
			System.out.println("this is search......");
		}
	
		@Test(priority=2)
		void advanceSearch()
		{
			System.out.println("this is advance search.....");
			
		}
		
		@AfterMethod
		void logout()
		{
			System.out.println("this is logout.........");
		}
		
		
		
		
		
		
		
		
}
