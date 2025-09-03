package Practise;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise2 {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://skirting4u.softdemonew.info/");
	//	driver.findElement(By.id("search")).sendKeys("860");
		
		driver.findElement(By.cssSelector("img[alt='Gemini Wall Panel Moulding']")).click();	
		driver.findElement(By.cssSelector("button[id='product-addtocart-button']" )).click();
		driver.findElement(By.cssSelector(".action.showcart")).click();
		driver.findElement(By.cssSelector("#top-cart-btn-checkout")).click();
		
		
		
		
		
	}

}
