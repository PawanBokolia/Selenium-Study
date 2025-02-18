package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepaving_order {

	public static void main(String[] args) throws InterruptedException {
		
	//	ChromeOptions options=new ChromeOptions();   //headless testing
	//	options.addArguments("--headless=new");
		
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://basepaving.softdemonew.info/brazilian-black.html");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		
		driver.findElement(By.xpath("//button[@form='product_addtocart_form']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Cart']//*[name()='svg']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role=\"region\"]/div/div/a"))).click();
		
		//checkout 
		driver.findElement(By.xpath("//input[@id='customer-email']")).sendKeys("pawan.bokoliaqa@gmail.com");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("Alstonefield");
		driver.findElement(By.name("region")).sendKeys("test");
		driver.findElement(By.name("city")).sendKeys("Ashbourne");
		driver.findElement(By.name("postcode")).sendKeys("DE6 2FX");
		driver.findElement(By.name("telephone")).sendKeys("202020202020");
		
		WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ko_unique_1']")));
		 js.executeScript("arguments[0].click();", element1);
		
		WebElement element2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='shipping-method-buttons-container']/div/button")));
		 js.executeScript("arguments[0].click();", element2);
		
		 //checkout using money order
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='checkmo']"))).click();
		 WebElement element3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='payment-method _active']/div[2]/div[4]/div/button"))); 	//checkout button 
		 js.executeScript("arguments[0].click();", element3);
		 
		//order number 
		WebElement orderno= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='checkout-success container py-4 px-6']/p/span")));
		System.out.println("order number is "+orderno.getText());
		
		driver.quit();
		
		
		
		
	}

}
