package Day5;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver= new ChromeDriver();
		
		
		
		
		//get(url) - opens the url on the browser 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		//getTitle() - return title of the page 
		System.out.println(driver.getTitle());   //OrangeHRM
		
		//getCurrenturl() - return url of the page 
		System.out.println(driver.getCurrentUrl());   //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		
		//getPageSource() - return source code of the page 
		//System.out.println(driver.getPageSource());
		
		//getWindowHandle() - return ID of the single browser window 
		String windowid= driver.getWindowHandle();
		System.out.println("Windowid " +windowid);  //5D749BA13C6EE7BF309E590177EF741B it will be different every time 
		
		//getWindowHandle() - return IDs of multiple browser window 
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowids=driver.getWindowHandles();
		System.out.println(windowids);
		

	}

}
