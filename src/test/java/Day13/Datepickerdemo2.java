package Day13;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Datepickerdemo2 {
	//user define method for converting month from string to ----->month
	static Month convertMonth(String month) {
		HashMap<String,Month> monthmap=new HashMap<String,Month>();
		monthmap.put("January", Month.JANUARY);
		monthmap.put("Fubruary", Month.FEBRUARY);
		monthmap.put("March", Month.MARCH);
		monthmap.put("April", Month.APRIL);
		monthmap.put("May", Month.MAY);
		monthmap.put("June",Month.JUNE);
		monthmap.put("July", Month.JULY);
		monthmap.put("August", Month.AUGUST);
		monthmap.put("September", Month.SEPTEMBER);
		monthmap.put("October", Month.OCTOBER);
		monthmap.put("November",Month.NOVEMBER);
		monthmap.put("December", Month.DECEMBER);
		
		Month vmonth=monthmap.get(month);
		
		if(vmonth==null)
		{
			System.out.println("invalid month......");
		}
		return vmonth;
		
	}
	
	static void selectdate(WebDriver driver, String requiredYear,String requiredMonth, String requiredDate) {
		
		
		//Select month 
		
		while(true)
		{
			String displaymonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();		
		
		//convert requiredmonth & displaymonth in to month objects
		
			Month expectedMonth=convertMonth(requiredMonth);
			Month currentMonth=convertMonth(displaymonth);
		
			//compare
			int result=expectedMonth.compareTo(currentMonth);   	//method use to difference between two month   	//predefine method
		
			//0 months are equal
			//>0 future month 
			//<0 pas month 
		
			if(result<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();   		 //past month 
			}
			else if (result>0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();		   	  //future month
			}
			else 
			{
				break;
			}
		
		}	
			
			//date selection 
			List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
			for(WebElement dt:alldates)
			{
				if(dt.getText().equals(requiredDate))
				{
					dt.click();
					break;
				}
				
			}
		
	}
	
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//input DOB
		String requiredYear="2022";
		String requiredMonth="June";
		String requiredDate="15";
	
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		
		//select year
		WebElement yeardropdown=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectyear=new Select(yeardropdown);
		selectyear.selectByVisibleText(requiredYear);
		
		selectdate(driver,requiredYear,requiredMonth,requiredDate);
		
	
		
		
		
		
	}

}
