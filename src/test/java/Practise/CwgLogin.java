package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CwgLogin {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String browser)
	{
		switch(browser)
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver= new EdgeDriver();break;
		default: System.out.println("browser error ");return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://crosthwaiteandgardiner.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="dp",priority=1)
	void login(String email, String password) throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='control']//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")).click();
	
		boolean status =driver.findElement(By.xpath("//span[@class='base']")).isDisplayed();
		if(status==true)
		{
			Actions act =new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//a[@href='https://crosthwaiteandgardiner.com/parts']"))).perform();
			act.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Abarth']"))).click().perform();
			driver.findElement(By.xpath("//a[normalize-space()='Oil filter housing mount CASTING']")).click();
			
			driver.findElement(By.xpath("//div[@class='qty-button increase']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
			act.moveToElement(driver.findElement(By.xpath("//span[@class='counter qty ic ic-char ib ib-size-s ib-rounded']"))).perform();
			driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
			driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
			Assert.assertEquals(status, true);
			
			
		}
		else
		{
			Assert.fail();
		}
	
	}
	
	@AfterClass
	void close()
	{
		driver.close();
	}
	
	
	
	@DataProvider(name="dp")
	Object [][] logindata()
			{
			Object[][] data= {
					{"pawan.bokoliaqa@gmail.com","pawan@95"},
					{"pawanbokoliaqa@gmail.com","pawa@95"},
					{"pawann@gmail.com","pawan@95"}
			};
			
			return data;
			}
	

}
