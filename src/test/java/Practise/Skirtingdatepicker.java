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

public class Skirtingdatepicker {
	
	static void datepicker(WebDriver driver,String selectmonth,String selectyear,String selectdate) {
		//selecting Month and years 
		WebElement month=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select drpmonth=new Select(month);
		drpmonth.selectByVisibleText(selectmonth);
		
		WebElement year=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select drpyear=new Select(year);
		drpyear.selectByVisibleText(selectyear);
		
		//selecting date
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));
		for(WebElement dt:dates)
		{
			if(dt.getAttribute("data-date").equals(selectdate))
			{
				dt.click();
				break;
			}
		}
	}
	
	static void productdetail(WebDriver driver) {
		 //adding product 
			WebElement dropdown1=driver.findElement(By.id("select_1"));
			Select select1= new Select(dropdown1);
			select1.selectByValue("25mm");
			
			WebElement dropdown2=driver.findElement(By.id("select_2"));
			Select select2=new Select(dropdown2);
			select2.selectByValue("70mm");
			
			WebElement dropdown3=driver.findElement(By.id("select_3"));
			Select select3=new Select(dropdown3);
			select3.selectByValue("Unprimed");
			
			WebElement dropdown4=driver.findElement(By.id("select_4"));
			Select select4=new Select(dropdown4);	
			select4.selectByValue("3050mm");
			
			WebElement dropdown5=driver.findElement(By.id("select_5"));
			Select select5=new Select(dropdown5);
			select5.selectByValue("No Rebate");
			
	}
	
	static void checkoutdetails(WebDriver driver) {
		driver.findElement(By.xpath("//input[@id=\"customer-email\"]")).sendKeys("pawan.bokoliaqa@gmail.com");
		driver.findElement(By.name("firstname")).sendKeys("test");
		driver.findElement(By.name("lastname")).sendKeys("test");
		driver.findElement(By.name("street[0]")).sendKeys("Alstonefield");
		driver.findElement(By.name("city")).sendKeys("Ashbourne");
		driver.findElement(By.name("postcode")).sendKeys("DE6 2FX");
		driver.findElement(By.name("telephone")).sendKeys("+2020202020202");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
	//	ChromeOptions options =new ChromeOptions();
	//	options.addArguments("--headless=new");
		
		WebDriver driver= new ChromeDriver();
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));  //Explicit wait 
		JavascriptExecutor js = (JavascriptExecutor) driver ;

		driver.get("https://skirting4u.softdemonew.info/catalog/product/view/id/46230/s/antique2-mdf-skirting-board/category/466");
		driver.manage().window().maximize();
		
		//adding product value 
		productdetail(driver); 			//calling productdetail method 
		
		WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Add to basket']"))); //add to cat button 
		js.executeScript("arguments[0].click();" ,element1);
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"minicart-wrapper\"]/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Proceed to Checkout']"))).click();
		
		//data filling in checkout page 
		checkoutdetails(driver);   //calling checkoutdetail method
		
		WebElement element2=driver.findElement(By.xpath("//input[@name='ko_unique_2']"));    //click on radio button //shipping method 
		js.executeScript("arguments[0].click();", element2);
		
		Thread.sleep(5000);	

		
		//datepicker
		WebElement scroll= driver.findElement(By.xpath("//div[normalize-space()='Select Delivery Slot']"));  //scroll till calendar
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		 
		WebElement deliverybutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dateForSlot'and @autocomplete='on']")));   //click on the calendar 
		Actions act=new Actions(driver);  																	//actions class object 		
		act.click(deliverybutton).perform();
		
		datepicker(driver,"Oct","2024","25");  //calling the datepicker method
	
		
		//timeslot button
		WebElement dileverytime=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='slotSelect']"))); //time slot button 
		act.moveToElement(dileverytime).click().perform();
	
	
		WebElement dileverytime1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@name='id_6']")));
		if(dileverytime1.isEnabled())
		{
			dileverytime1.click();
		}
		else 
		{
			System.out.println("element is not visible ");
		}
		
		//orderplace button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button action continue primary']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='checkmo']"))).click();
		
/*		WebElement element3=driver.findElement(By.xpath("//div[@class='payment-method _active']//div[@class='checkout-agreement field choice required']//input"));
		js.executeScript("arguments[0].click()", element3);
		
		WebElement element4=driver.findElement(By.xpath("(//button[@title='Place Order'])[1]"));
		System.out.println(element4.isEnabled());
		
		
		driver.quit();
*/		
	}
}
