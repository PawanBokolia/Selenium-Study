package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test990 {

	public static void main (String []args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://jerrysartarama.com/");
		driver.findElement(By.linkText("Canvases & Painting Surfaces")).click();
		driver.findElement(By.xpath("//img[@title='Canvas Panels & Boards']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.jerrysartarama.com/senso-linen-all-media-panels'][normalize-space()='Shop Now']"));
		driver.findElement(By.xpath("//img[@gmail.com"));
		
		
		
	
	}
}
