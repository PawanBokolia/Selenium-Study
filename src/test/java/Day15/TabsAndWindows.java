package Day15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);	    	  //use to open another page on new tab 
		driver.switchTo().newWindow(WindowType.WINDOW);			//use to open another page on the new window 
		
		driver.get("https://www.orangehrm.com/");

	}

}

