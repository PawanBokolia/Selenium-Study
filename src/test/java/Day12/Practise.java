package Day12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		
		
		WebElement total=driver.findElement(By.xpath("//ul[@id='pagination']//li"));
		total.getSize();
	
	
	
	
	
	
	
	}
}