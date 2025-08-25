package Practise2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPractise {

	
	public static void main(String []args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://flags.co.uk/contact-us");
		driver.manage().window().maximize();
		
		
		
		WebElement a =	driver.findElement(By.xpath("//form[@class=\"form form-login\"]"));
//		js.executeScript("arguments[0].click();", a);
		a.click();
		
		
		
		
		
		
		
		
		
	}
}
