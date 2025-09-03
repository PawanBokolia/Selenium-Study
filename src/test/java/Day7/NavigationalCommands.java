package Day7;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://demo.nopcommerce.com/");  //accept URL only in the string format 
	
		//driver.navigate().to("https://demo.nopcommerce.com/");
		
		//navigation to object 
		//URL myurl =new URL("https://demo.nopcommerce.com/");
		//driver.navigate().to(myurl);
		
		
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		
		driver.navigate().refresh();
		
		
	}

}
