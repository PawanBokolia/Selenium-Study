package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScentPerfiqque_checkout {

	public static void main (String [] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		
		WebDriver driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		driver.get("https://staging.scentperfique.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30)); 	 //Explicit wait 
		
		Actions act=new Actions (driver);
		
		WebElement menu=driver.findElement(By.xpath("//a[@title='Candle Making']//span[contains(text(),'Candle Making')]"));
		WebElement menu2=driver.findElement(By.xpath("//a[contains(text(),'Candle Boxes')]"));
		act.moveToElement(menu).moveToElement(menu2).click().perform();
		
		WebElement element1=driver.findElement(By.linkText("Ivory Gloss Candle Box"));
		js.executeScript("arguments[0].click();", element1);
		
		WebElement productoptions=driver.findElement(By.xpath("//select[@id='attribute166']"));
		Select drpoptions=new Select(productoptions);
		drpoptions.selectByValue("845");
		
		driver.findElement(By.xpath("//span[@class='block sm:block lg:block']")).click();
		driver.findElement(By.xpath("//button[@id='menu-cart-icon']//*[name()='svg']")).click();
		
		//Checkout details 
		driver.findElement(By.xpath("//a[normalize-space()='Proceed to Checkout']")).click();
		driver.findElement(By.id("customer-email")).sendKeys("pawan.bokolliaqa@gmail.com");
		driver.findElement(By.name("firstname")).sendKeys("test");
		driver.findElement(By.name("lastname")).sendKeys("test");
		driver.findElement(By.name("street[0]")).sendKeys("Alstonefield");
		driver.findElement(By.name("city")).sendKeys("Ashbourne");
		driver.findElement(By.name("postcode")).sendKeys("DE6 2FX");
		driver.findElement(By.name("telephone")).sendKeys("202020202020");
		
		WebElement drpcountrys=driver.findElement(By.name("region_id"));
		Select drpcountry=new Select(drpcountrys);
		drpcountry.selectByValue("1053");
		
		//shipping radio button 
		WebElement element2=driver.findElement(By.xpath("//input[@name='ko_unique_1']"));
		js.executeScript("arguments[0].click();", element2);
		
		WebElement element3=driver.findElement(By.xpath("//button[@class='button action continue primary']"));
		js.executeScript("arguments[0].click();", element3);
		
		//debit card payment 
		WebElement element4= driver.findElement(By.xpath("//span[normalize-space()='Debit or Credit Card']"));  
		js.executeScript("arguments[0].click();", element4);
		
		driver.switchTo().frame("braintree-hosted-field-number");
		driver.findElement(By.xpath("//input[@id='credit-card-number']")).sendKeys("4242424242424242");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("braintree-hosted-field-expirationDate");
		driver.findElement(By.xpath("//input[@placeholder='MM/YYYY']")).sendKeys("0225");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("braintree-hosted-field-cvv");
		driver.findElement(By.name("cvv")).sendKeys("123");
		
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='agreement_braintree_1']"))).click();
		
		
		
		
		//driver.quit();
		
		
		
		
	}
}
