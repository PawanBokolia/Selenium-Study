package Practise;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise4 {
	public static void main (String []args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.linkText("Selenium in biology")).click();
		driver.findElement(By.linkText("Selenium (software)")).click();
		
		
		//changing the focus on the other window and performing action 
		
		Set<String>windowids=driver.getWindowHandles();
		for(String windowid:windowids) {
			driver.switchTo().window(windowid);
			if(driver.getTitle().equals("Selenium - Wikipedia")) {
				driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("pawan");  //you have add a action with in the if statement 
			}else {
				driver.close();
			}
	
			}
		
		
		
	}
}
		
	
		
			
			
		
		
		
	
	
		
