package Practise2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practise {
	
	
	public static void datepicker(WebDriver driver,String month,String year, String date)
	{
		WebElement Currentmonth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		WebElement Currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
		
		while(true)
		{
			if(Currentmonth.getText().equals(month) && Currentyear.getText().equals(year))
			{
				break;
			}
				driver.findElement(By.xpath("//a[@title='Prev']")).click();
		}
		
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a"));
		for(WebElement a :alldates)
		{
			if(a.getText().equals(date))
			{
				a.click();
				break;
			}
		}
		
	}
	
	public static void  main(String []args) throws InterruptedException  {
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://m2dev.jerrysartarama.com/faq/email-signup-exclusive-club");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("(//a[@class='ltkmodal-close'])[1]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='birthday']")).click();
		Thread.sleep(5000);
		try 
		{
			datepicker(driver,"January","2021","7");	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			datepicker(driver,"January","2021","7");
		}
		
		
	}

	
	
}
