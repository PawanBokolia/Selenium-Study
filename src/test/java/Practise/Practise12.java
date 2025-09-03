package Practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practise12 {

	WebDriver driver;
	
	@BeforeClass
	void start()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	void teardown()
	{
		driver.close();
	}
	
	void datepicker(String month, String year ,String date)
	{
		
		while(true)
		{
		String currentmonth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentmonth.equals(month) & currentyear.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> currentdate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement a:currentdate ) 
		{
			if(a.getText().equals(date));
			{
				a.click();
				break;
			}
		}
		
	}
	
	@DataProvider(name="dp")
	Object[][]logindata()
	{
		Object[][] data= {
				{"pawan.bokoliaqa@gmail.com","paw@1234"},
				{"admin","Admin@123"},
				{"Admin", "admin123"}
		};
		return data;
	}

	
	
	
	
	@Test(priority=1,dataProvider ="dp")
	void dateselect(String username,String password) 
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String dash=driver.findElement(By.xpath("(//h6[normalize-space()='Dashboard'])[1]")).getText();
		Assert.assertEquals(dash, "Dashboard");
	}
	
	
	
	
}
