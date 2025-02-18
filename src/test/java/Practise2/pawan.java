package Practise2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pawan {

	public static void main (String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.trailertek.com/trailer-parts/trailer-lights/led-work-lights/led-curved-work-light-bar-635mm");
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
	
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='action showcart my-tooltip-bottom tooltip-center header-icon']"))).click();
		WebElement colour = driver.findElement(By.xpath("//a[@class='action btn viewcart']"));
		String backcolor= colour.getCssValue("background-color");
		System.out.println(backcolor);
		
		
		
		
		
		
	}
}
