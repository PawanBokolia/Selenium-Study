package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class M2pp_Order {
	public static void main (String []args) throws InterruptedException {
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
		
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
	       
	     
		
		driver.get("https://m2pp.jerrysartarama.com/charvin-extra-fine-oil-paints");
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.xpath("//div[@class='grid-addto']//div//div//div//input[3]")).click();
		driver.findElement(By.xpath("//div[@class=\"grid-addto\"]//div//div//div//button")).click();
		
		Thread.sleep(3000);
		
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//aside[@role='dialog']//footer//button[1]"))).click();      	  		  //click on ok button on the popup 
	    driver.findElement(By.xpath("//body/div/header/div/div/div[@data-block='minicart']/a[@role='button']/span[1]")).click();  				//click on mini cart 
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label=\"mini cart\"]//div//div//div//div[3]//a"))).click(); 							//click on checkout button 
		
		//cart page 
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Proceed to Checkout']"))).click();
		
	    //log in 
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[contains (@type,'email') and contains(@id, 'customer-email')]")).sendKeys("pawan.bokoliaqa@gmail.com");
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("customer-password"))).sendKeys("pawan@95");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-action='checkout-method-login']"))).click();
		
	    Thread.sleep(7000);
	    
	    //checkout main 
	    WebElement element1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-continue='checkout-shipping-address']")));
	    js.executeScript("arguments[0].click();",element1 );
	    
	  
	    WebElement element2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody//tr[@class='row amcheckout-method'][2]")));	 //shipping method
	    js.executeScript("arguments[0].click();", element2);

	    WebElement element3=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-next='payment-group']")));					//shipping method
	    js.executeScript("arguments[0].click();", element3);
	    
	    
	    WebElement element4= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='checkmo']")));   			//payment method 
	    js.executeScript("arguments[0].click();", element4);
	    
	    WebElement element5= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-next='review-summary']")));
	    js.executeScript("arguments[0].click();", element5);
	    
	    //order place button
	    WebElement element6=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@type, 'submit') and contains(@class,'action primary checkout amasty')])[1]")));
	    js.executeScript("arguments[0].click();", element6);
	    
	    //order number 
	    WebElement orderno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"order-number\"]")));
	    System.out.println("order no is = " +orderno.getText());
	    
	    driver.quit();
	    
		
		
	}
	
}
