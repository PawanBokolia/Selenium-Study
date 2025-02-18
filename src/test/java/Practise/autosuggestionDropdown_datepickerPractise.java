package Practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class autosuggestionDropdown_datepickerPractise {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver ();
		driver.get("https://dummy-tickets.com/buyticket");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//input[@name='source[]'])[1]")).sendKeys("delhi");
		List <WebElement> suggestions1 =driver.findElements(By.xpath("//form[@id='flight_oneway']//div//ul//li"));
		Thread.sleep(3000);
		for(WebElement option1:suggestions1 ) {
			if(option1.getText().equals("Indira Gandhi International Airport, "));
			{	option1.click();
				break;
			}
		}
		
	
		driver.findElement(By.xpath("(//input[@class='suggestion-input required mb-2'])[2]")).sendKeys("mumbai");
		Thread.sleep(3000);
		
		List <WebElement> suggestions2 =driver.findElements(By.xpath("(//div[@class='col-sm-12 p-0 suggestion-container'])[2]//ul//li"));
		for(WebElement option2:suggestions2 )
		{
			if(option2.getText().equals("Chhatrapati Shivaji International Airport,"));
			{ 	option2.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@name='departure[]'])[1]")).click();
		
		//select month 
		WebElement drpmonth=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select reqmonth=new Select (drpmonth);
		reqmonth.selectByValue("5");
	
		//select year
		WebElement drpyear=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select reqyear=new Select (drpyear);
		reqyear.selectByValue("2023");
		
		//select date
		List<WebElement> dates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement dt:dates)
		{
			if(dt.getText().equals("7"))
			{
				dt.click();
				break;
			}
			
		}
		
		
		
	}

}
