package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_locators {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
/*		//Tag and id     //tag#id
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("t-shirt"); 
		driver.findElement(By.cssSelector("#small-searchterms"));                           //Approach 2 
		
*/		
		
		//Tag and Class    //tag.class
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("t-shirt");
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("t-shirt");       //approach 2  it can locate multiple element
		
		
		
		
		//Tag and attribute    //tag[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("T-shirt");  //  \ this in "" for another "" or use '' instead 
		driver.findElement(By.cssSelector("[placeholder=\"Search store\"]")).sendKeys("T-shirt");
		
		
		
		
		//Tag class and attribute 
		driver.findElement(By.cssSelector("input.search-box-text[name='q'])")).sendKeys("T-shirt");
		driver.findElement(By.cssSelector(".search-box-text[name='q')")).sendKeys("T-shirt");            //approach 2
		
		
	//	driver.quit();
	}

}
