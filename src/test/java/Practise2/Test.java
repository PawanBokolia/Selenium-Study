package Practise2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String args[]) {
		
		
		WebDriver driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.jerrysartarama.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		try {
			driver.findElement(By.cssSelector("a[class='ltkmodal-close'][ title='Close']")).click();
			}
		catch(Exception e )
		{
			System.out.println("no pop up present");
		}
		
		
		driver.switchTo().alert().accept();
		
		
		
		
		
		
		
		
		
		
		
	}
}
