package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test123 {
	
	
	
	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeClass
	void setup(String br) 
	{
		switch(br)
		{
		case "edge" : driver=new EdgeDriver(); break;
		case "chrome" : driver = new ChromeDriver(); break;
		default : System.out.println("browser error"); return;
		}
		
		driver.get("https://crosthwaiteandgardiner.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	}
		
		@Test(dataProvider="dp")
		void test(String email, String password) throws InterruptedException
		{
			Thread.sleep(10000);
			driver.findElement(By.xpath("//button[normalize-space()='Accept Cookies']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
			driver.findElement(By.xpath("//div[@class='control']//input[@id='email']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			
			Thread.sleep(3000);
			WebElement scroll=driver.findElement(By.xpath("//button[@class='action login primary']"));
			scroll.click();
			
			
			boolean status = driver.findElement(By.xpath("//span[@class='base']")).isDisplayed();
			if(status==true)
			{
				driver.findElement(By.xpath("//a[normalize-space()='Sign Out']")).click();
			}
		}
		

		@DataProvider(name="dp")
		Object [][] data()
		{
			Object[][] data1= 
				{
					{"pawanbokolia@gmail.com","@1234"},
					{"pawan@gmail.com","@pwda"},
					{"pawan.bokoliaqa@gmail.com","pawan@95"}
				};
			return data1;
		}
		

		@AfterClass
		void close()
		{
			driver.close();
		}
		



}
