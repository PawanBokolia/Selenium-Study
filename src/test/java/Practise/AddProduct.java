package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProduct {
	
	
	static void adminlogin(WebDriver driver,String username,String password)
	{
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@id='login']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@class='action-login action-primary']")).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://scentperfique.softdemonew.info/websitecontrol/admin/dashboard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(40));  //Explicit wait 
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		Actions act=new Actions(driver);
		
		//Login Admin
		adminlogin(driver,"scent","scent@126");
		
		//add new product button 
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='menu-magento-catalog-catalog']/a"))).click();
		
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-ui-id='menu-magento-catalog-catalog-products']/a")));
		js.executeScript("arguments[0].click()", element1);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='add_new_product-button']"))).click();
		Thread.sleep(4000);
		
		//product detail 
		driver.findElement(By.xpath("//input[@name='product[name]']")).sendKeys("test123456");
		driver.findElement(By.xpath("//input[@name='product[price]']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@name='product[quantity_and_stock_status][qty]']")).sendKeys("10");
		driver.findElement(By.xpath("//div[contains(text(),'Select...')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Pool Copings']"))).click();
		driver.findElement(By.xpath("//button[@class='action-default']"));
		
		WebElement content=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[1]//strong[1]")));
		js.executeScript("arguments[0].scrollIntoView();", content);
		js.executeScript("arguments[0].click();", content);
		
		driver.switchTo().frame("product_form_short_description_ifr");
		driver.findElement(By.xpath("//body[@id='html-body']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n"
				+ "\r\n"
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n"
				+ "\r\n"
				+ "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n"
				+ "\r\n"
				+ "");
		
		driver.switchTo().defaultContent();
		
		WebElement images=driver.findElement(By.xpath("//span[normalize-space()='Images And Videos']"));
		js.executeScript("arguments[0].scrollIntoView();",images);
		js.executeScript("arguments[0].click();", images);
		

		WebElement upload =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fileupload']")));
		act.moveToElement(upload).click(upload).perform();
		upload.sendKeys("D:\\Demo pics\\demo1.jpeg");
		
				
		
		

	}

}
