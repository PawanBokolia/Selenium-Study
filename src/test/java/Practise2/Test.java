package Practise2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String args[]) throws InterruptedException {
		
		
		WebDriver driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		JavascriptExecutor js =(JavascriptExecutor) driver;
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.get("https://www.jerrysartarama.com/mimik-recycled-pet-canvas");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ltkmodal-close"))).click();

		driver.findElement(By.xpath("(//input[@value='+'])[6]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@title=\"Add\"])[5]")).click();
		
		Thread.sleep(3000);
		WebElement pe =driver.findElement(By.xpath("//button[1]"));
		js.executeScript("arguments[0].click();", pe);
		
		
		
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		String c =driver.findElement(By.xpath("//a[@class='action viewcart']")).getCssValue("background-color");
		System.out.println(c);
		
//		Assert.assertEquals(a, )
		
		
		
		
		
		
		
		
		
		
		
	}
}
