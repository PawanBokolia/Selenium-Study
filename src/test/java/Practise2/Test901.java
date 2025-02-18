package Practise2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test901 {

	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.scentperfique.com/");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		
		WebElement z[]= {
		driver.findElement(By.xpath("//a[@title='Candle Making']//span[contains(text(),'Candle Making')]")),
		driver.findElement(By.xpath("//a[contains(@title,'')]//span[contains(text(),'Candles Private Label')]")),
		driver.findElement(By.xpath("(//a[@title='Diffusers & Fresheners'])[3]")),
		driver.findElement(By.xpath("(//span[contains(text(),'Fragrance Oils')])[3]"))};
		
		for(WebElement y:z)
		{
			act.moveToElement(y).perform();
			System.out.println(y.getText());
			System.out.println(y.getLocation());
		}
		
		
		
		
		
		
		
		
		
	}
}
