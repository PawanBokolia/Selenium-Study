package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamic {

	public static void main(String arg []) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("pawan");
		
		Thread.sleep(4000);
		List<WebElement> suggestion = driver.findElements(By.xpath("//div[@class='erkvQe']//ul[@role='listbox']//li//div"));
		for(WebElement a : suggestion)
		{
			if(a.getText().equalsIgnoreCase("pawan kalyan"))
			{
				a.click();
				break;
			}
		}
		
		
		
		
		
		
	}
}
