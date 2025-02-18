package Practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	public static void datepicker(WebDriver driver, String year, String month, String date )
	{
		while(true)
		{
			WebElement a = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
			WebElement b= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
			
			if(a.getText().equals(month) && b.getText().equals(year))
			{
				break;
			}	
				driver.findElement(By.xpath("//a[@title='Prev']")).click();
		}
		
		List <WebElement> c = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
		for(WebElement d : c )
		{
			
			if(d.getText().equals(date))
			{
				d.click();
			}
		}
	}
	
	public static void main (String args [] ) throws InterruptedException {
		
		WebDriver driver;
		String br="Chrome";
		
		switch (br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver(); break;
		case "firefox" : driver = new FirefoxDriver();break;
		case "edge" : driver = new EdgeDriver(); break;
		default : System.out.println("invalid browser ");return;
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Actions act = new Actions (driver);
		driver.get("https://mrd.softdemonew.info/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("close-button"))).click();
		WebElement a = driver.findElement(By.xpath("//a[@href='https://www.jerrysartarama.com/canvas-painting-surfaces']"));
		act.moveToElement(a).click().perform();
		driver.navigate().back();
		
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Enter your email address']"));
		js.executeScript("arguments[0].setAttribute('value','pawan.bokoliaqa@gmail.com')",email);
		
		driver.findElement(By.xpath("//span[normalize-space()='Subscribe']")).click();
		driver.findElement(By.xpath("//input[@name='birthday']")).click();
		
		WebElement m = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select drp1 = new Select(m);
		drp1.selectByValue("5");

		WebElement y = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select drp2 = new Select(y);
		drp2.selectByValue("1995");
		
		List <WebElement> c = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td/a"));
		for(WebElement d : c )
		{
			if(d.getText().equals("7"))
			{
				d.click();
			}
		}

		driver.navigate().to("https://www.jerrysartarama.com/");
		
		WebElement b = driver.findElement(By.xpath("//a[@href='https://www.jerrysartarama.com/canvas-painting-surfaces']"));
		act.moveToElement(b).click().perform();
		
		driver.findElement(By.xpath("//div[@class='column main']//div[1]//div[1]//a[1]")).click();
		
		WebElement ele = driver.findElement(By.xpath("//a[normalize-space()='Practica Economy Stretched Cotton Canvas']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		js.executeScript("arguments[0].click();", ele);
		js.executeScript("window.scrollBy(0 ,document.body.scrollHeight)");
		
		
		
	}
}
