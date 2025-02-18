package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practise5 {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://cimacbox.softdemonew.info/new-products/protection");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		WebElement a= driver.findElement(By.xpath("//dd[@class='filter-options-content']//span[1]"));
		System.out.println(a.getLocation());
		act.dragAndDropBy(a, 200, 461).perform();

		WebElement b=driver.findElement(By.xpath("//div[@class='cell small-12 medium-3 category-listing__sidebar']//span[2]"));
		System.out.println(b.getLocation());
	}

}
