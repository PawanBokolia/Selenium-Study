package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test1234 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Actions act = new Actions(driver);
		driver.navigate().to("https://m2dev.jerrysartarama.com/");
		driver.findElement(By.className("ltkmodal-close")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	
		driver.findElement(By.cssSelector("div[class='header-content-right'] ul[class='header links'] button[type='button']")).click();
		driver.findElement(By.cssSelector("li[class='customer-welcome active'] li[class='link authorization-link'] a[class='log-in-link']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("pawan.bokoliaqa@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("pawan@95");
		driver.findElement(By.cssSelector("button[class='action login primary']")).click();
		
		
		
//		WebElement menu = driver.findElement(By.xpath("//span[text()='Paints & Mediums']"));
		
//		act.moveToElement(menu).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Oil Paints']"))).click();
		driver.quit();
		
		
		
	}

}
