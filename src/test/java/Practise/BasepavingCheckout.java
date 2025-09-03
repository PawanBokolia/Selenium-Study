package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasepavingCheckout {
	public static void main(String args[]) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(25));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();

		driver.get("https://basepaving.softdemonew.info/");

		driver.findElement(By.xpath("//img[@title='Brazilian Black']")).click();
		driver.findElement(By.cssSelector("button[title='Add to Cart']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();

		driver.findElement(
				By.xpath("//div[@class='relative py-6 bg-white border-t border-container border-lightgraynew']/div/a"))
				.click();
		driver.findElement(By.xpath("//a[@title='Proceed to Checkout']")).click();

		// checkout
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='customer-email']")).sendKeys("pawan.bokoliaqa@gmail.com");
		// driver.findElement(By.xpath("//button[@data-role='opc-continue']")).sendKeys("pawan.bokoliaqa@gmail.com");
		driver.findElement(By.name("firstname")).sendKeys("test");
		driver.findElement(By.name("lastname")).sendKeys("test");
		driver.findElement(By.name("street[0]")).sendKeys("Alstonefield");
		driver.findElement(By.name("city")).sendKeys("test");
		driver.findElement(By.name("postcode")).sendKeys("DE6 2FX");
		driver.findElement(By.name("telephone")).sendKeys("12345678");
		
		WebElement chclick=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ko_unique_1']")));
		chclick.click();

		WebElement txtcheckoutbutton = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[@class='button action continue primary' and @type='submit' and @data-role='opc-continue']")));
		txtcheckoutbutton.click();
		// driver.findElement(By.xpath("//button[@class='button action continue primary'
		// and @type='submit' and @data-role='opc-continue']")).click();

		//Thread.sleep(25000);
		//driver.findElement(By.name("payment[method]")).click();

		Thread.sleep(4000);
		//driver.findElement(By.xpath("//button[@title='Place Order']")).click();

		String a = driver.findElement(By.xpath("//div[@class='checkout-success']/p/span")).getText();
		System.out.println(a);
		


	}
}
