package Practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.AllArguments;

public class New_skirting {

	
	static void product_selection(WebDriver driver)
	{
		WebElement selection1 =driver.findElement(By.xpath("//select[@id='select_1']"));
		Select option1 = new Select(selection1);
		option1.selectByValue("15mm");
		
		WebElement selection2 =driver.findElement(By.xpath("//select[@id='select_2']"));
		Select option2 = new Select(selection2);
		option2.selectByValue("100mm");
		
		WebElement selection3 =driver.findElement(By.xpath("//select[@id='select_3']"));
		Select option3 = new Select(selection3);
		option3.selectByValue("Primed + £3.95");
		
		WebElement selection4 =driver.findElement(By.xpath("//select[@id='select_4']"));
		Select option4 = new Select(selection4);
		option4.selectByValue("3050mm");

		WebElement selection5 =driver.findElement(By.xpath("//select[@id='select_5']"));
		Select option5 = new Select(selection5);
		option5.selectByValue("Cable + £3.50");
		
	}	
	
	static void checkout_details(WebDriver driver,String email, String firstname, String lastname,String address, String city, String postcode, String telephone)
	{
		driver.findElement(By.xpath("//input[@id='customer-email']")).sendKeys(email);
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("street[0]")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("postcode")).sendKeys(postcode);
		driver.findElement(By.name("telephone")).sendKeys(telephone);
	}
	
	static void datepicker(WebDriver driver,String month, String year,String date ) 
	{
		while(true) 
		{
			
			String currentmonth = driver.findElement(By.xpath("//select[@aria-label='Select month']")).getText();
			String currentyear = driver.findElement(By.xpath("//select[@aria-label='Select year']")).getText();
			
			if(currentmonth.equals(month) && currentyear.equals(year))
			{
					break;
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click();	
			
			
			List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
			for(WebElement dates: alldates) {
				if(dates.getAttribute("data-date").equals(date))
				{
					dates.click();
					break;
				}
			}
		}
	}
	
	static void cookies(WebDriver driver, WebDriverWait wait) 
	{
		try 
		{
			WebElement cokkies=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btn-cookie-allow']")));
			cokkies.click();
		}
		catch(Exception e) 
		{
			System.out.println("cookies is not present");
		}
	}
	
	
	public static void main (String []args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.skirting4u.co.uk/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(40));
	JavascriptExecutor js=(JavascriptExecutor) driver;
	Actions act = new Actions(driver);
	cookies(driver,wait);
	
	act.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Skirting Boards']"))).click().perform();
	WebElement elementScroll = driver.findElement(By.xpath("//img[@alt='Antique MDF Skirting Board']"));
	js.executeScript("arguments[0].scrollIntoView();", elementScroll);
	
	driver.findElement(By.xpath("//img[@alt='Antique MDF Skirting Board']")).click();
	
	//Product details adding 
	product_selection(driver);
	
	Thread.sleep(3000);
	WebElement element1=driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
	js.executeScript("arguments[0].click();", element1);
	
	WebElement element2=driver.findElement(By.xpath("//a[@class='action showcart']"));
	WebElement element3=driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
	js.executeScript("arguments[0].click();", element2);
	js.executeScript("arguments[0].click();", element3);
	
	//Checkout
	
	checkout_details(driver,"pawan.bokoliaqa@gmail.com","test","test","Alstonefield","Ashbourne","DE6 2FX", "202020202020");
	driver.findElement(By.xpath("(//table[@class='table-checkout-shipping-method']/tbody/tr/td)[5]")).click();
	
	
	WebElement element4=driver.findElement(By.xpath("//input[@id='dateForSlot']"));
	js.executeScript("arguments[0].scrollIntoView();", element4);
	
	//DatePicker
	act.moveToElement(element4).click().perform();
	datepicker(driver,"Oct","2024","31");
	
	
	

	
	}
}
