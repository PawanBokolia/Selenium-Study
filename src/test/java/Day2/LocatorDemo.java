package Day2;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LocatorDemo {

	public static void main(String[] args) {
		
    	WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");   //use to open URL
		
		driver.manage().window().maximize();    //for maximize the window size //full screen 
		
/*	    //Name 
		
		driver.findElement(By.name("search")).sendKeys("mac");   // sendkeys is used to add some element // Find element is used to find the element 
		
		
		//ID
		
		boolean logoDisplayStatus=driver.findElement(By.id("logo")).isDisplayed();
		System.out.println(logoDisplayStatus);
		
		
		
		//LinkText and parcialLinktest 

		//driver.findElement(By.linkText("Tablets")).click();
		driver.findElement(By.partialLinkText("Tab")).click();  // partialLinkText 
		



	
		//Class name 
		
		List<WebElement> headerLinks=driver.findElements(By.className("list-inline-item"));    //List is used because there are multile dublicates 
		System.out.println(headerLinks.size());

		
		
		
		
		//tagname
		
		List<WebElement> links=driver.findElements(By.tagName("a"));               //list is used store multiple data 
		System.out.println("Total number of links are "+links.size());
*/
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println("Total number of images are "+images.size());
		
		
		
		
		
	}

}
