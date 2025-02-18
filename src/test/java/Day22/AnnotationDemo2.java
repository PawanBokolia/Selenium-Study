package Day22;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationDemo2 {
	
	/*
	TC2
	------
	1) login -----@BeforeClass
	2) search ----@Test
	3) adv search -----@Test
	4) logout--------@AfterClass

	*/

			
			@BeforeClass
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
				System.out.println("this is advance search......");
				
			}
			
			@AfterClass
			void logout()
			{
				System.out.println("this is logout.........");
			}
			
			
			
			
			
			
			
			
	

}
