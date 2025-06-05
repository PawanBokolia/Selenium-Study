package Practise2;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test123 {

//	public static String randomString()
//	{
//		String generatedString =RandomStringUtils.randomAlphabetic(6);
//		return generatedString;
//	}

	public static String randomString ()
	{
		String genrateString  = RandomStringUtils.randomAlphabetic(4);
		return genrateString;
	}
	
	
	
	
		@Test
		public static void test()throws InterruptedException {		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://web.toonautomation.softdemonew.info:8046");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));



		driver.findElement(By.xpath("//button[normalize-space()=\"Log In\"]")).click();
		driver.findElement(By.xpath("//button[normalize-space()=\"Create an account\"]")).click();
		driver.findElement(By.xpath("//button[normalize-space()=\"Sign up with Email\"]")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,\"First name\")]")).sendKeys("pawan");
		driver.findElement(By.xpath("//input[@placeholder=\"Last name\"]")).sendKeys("Bokolia");
		driver.findElement(By.xpath("//input[@placeholder=\"DD\"]")).sendKeys("01");
		driver.findElement(By.xpath("//input[@placeholder=\"MM\"]")).sendKeys("10");
		driver.findElement(By.xpath("//input[@placeholder=\"YYYY\"]")).sendKeys("1990");
		driver.findElement(By.xpath("//input[@placeholder=\"Email address\"]")).sendKeys("pawan"+randomString()+"@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("Pawan@95");
		driver.findElement(By.xpath("//button[normalize-space()=\"Next\"]")).click();

		Thread.sleep(5000);
		String targetpage = driver.findElement(By.xpath("//h1[normalize-space()=\"Add payment details\"]")).getText();

		if(targetpage.equals("Add payment details"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false	);
		}

		Thread.sleep(5000);
		driver.navigate().back();
		driver.get("http://web.toonautomation.softdemonew.info:8046/");	

		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@aria-haspopup=\"menu\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Logout']"))).click();
		String loginText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-haspopup=\"menu\"]//button"))).getText();
		
		if(loginText.equals("Log In"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		//		driver.quit(); 



	}
		
		
		
		
}
