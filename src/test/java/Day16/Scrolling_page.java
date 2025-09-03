package Day16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling_page {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		//1)Scroll down page by pixel no.
//		js.executeScript("window.scrollBy(0,1500)", "");
//		System.out.println(js.executeScript("return window.pageYOffset"));    		 //use to get the pixel of the page scroll
		

		//2) scroll the page till element is visible 
//		WebElement ele=driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
//		js.executeScript("arguments[0].scrollIntoView();", ele);
//		System.out.println(js.executeScript("return window.pageYOffset"));
		
		
		//3) scroll the page till end of the page 
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		System.out.println(js.executeScript("return window.pageYOffset"));
		
		//4) scrolling up to initial position 
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	
		
		//for horizontal scroll bar use document.body.scrollwidth
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
