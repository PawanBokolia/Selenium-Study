package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test789 {
	WebDriver driver;

	@BeforeTest
	void open() 
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://m2stage.gaugemasterretail.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void t1() {

		SoftAssert soft = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("button[aria-label=\"Close dialog\"]")).click();

		driver.findElement(By.cssSelector("button[aria-label='My Account'] svg")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Sign In']"))).click();
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("testdev123@gmail.com");
		driver.findElement(By.cssSelector("input[title='Password']")).sendKeys("Admin@123");
		driver.findElement(By.cssSelector("button[name='send']")).click();

		driver.findElement(By.cssSelector("button[title='Cart']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();

		String cart = driver.findElement(By.cssSelector(".base")).getText();
		soft.assertEquals(cart, "Shopping Cart");

		WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart-1895898-qty")));
		a.click();
		a.clear();
		a.sendKeys("5");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Update Shopping Cart']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Proceed to Checkout']"))).click();

		String checkout = driver.findElement(By.xpath("//div[normalize-space()='Shipping Address']")).getText();

		soft.assertEquals(checkout, "Shipping Address");

		driver.findElement(By.cssSelector("input[value='Magento_Postage_nextdayfoc']")).click();
		driver.findElement(By.cssSelector(".button.action.continue.primary")).click();

		String c = driver.findElement(By.cssSelector("div[class='payment-group'] div[class='step-title']")).getText();

		Assert.assertEquals(c, "Payment Method");
		soft.assertAll();
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
