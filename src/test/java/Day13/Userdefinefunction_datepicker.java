package Day13;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Userdefinefunction_datepicker {

	static void Futuredates(WebDriver driver,String month,String year,String date) 
	{
		//select Future months and year 
		while(true)
		{
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
			if(currentmonth.equals(month) && currentyear.equals(year))
			{
				break;
			}
		
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();  //next button 
		}
		
		 //Future dates
		List<WebElement> alldates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}
	
	static void Pastdates(WebDriver driver,String month,String year,String date)
	{
		
		//select past years and dates 
		while(true)
		{
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
			if(currentmonth.equals(month) && currentyear.equals(year))
			{
				break;
			}
		
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();  //next button 
		}
		
		//past dates
		List<WebElement> alldates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		
		for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		//Method 1 : declearing the variables 
/*		String date="10";
		String year="2025";
		String month="May";
		
		Futuredates(driver,month,year,date);
*/		
		
		//method 2 : directly 
		Futuredates(driver,"May","2025","10");
		
		
		
		
	}

}
