package Day1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

/* test case 
  ----------
 1)lunch browser (chrome)
 2)open URL https://demo.opencart.com/
 3)validate the title should be "your store"
 4)close browser
 */
 
public class First_test_case {

	public static void main(String[] args) {
		
	//	1)lunch browser (chrome)
	//	ChromeDriver driver=new ChromeDriver();
		WebDriver driver=new ChromeDriver();     //this approach is more useful as it can be used for all the the browser 
		
		
	//	2)open URL https://demo.opencart.com
		driver.get("https://demo.opencart.com/");
		
	// 3)validate the title should be "your store"
		
		String act_title=driver.getTitle();
		
		if(act_title.equals("Your Store"))
		{
			System.out.println("test pass");
		}
		else {
			System.out.println("test fail");
		}
		
	//	 4)close browser
		
		  driver.close();  	    //approach 1 
		  // driver.quit();     //approach 2
		
		
	}

}
