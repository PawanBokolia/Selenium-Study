package Practise2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HOF_quoteform {

	public static void main(String args[]) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://flags.softdemonew.info/halyard");
		
		driver.findElement(By.xpath("(//div[@class=\"product-social-links\"]//form//button)[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='control'])[1]//input")).sendKeys("test");
		driver.findElement(By.xpath("(//div[@class='control'])[2]//input")).sendKeys("test");
		driver.findElement(By.xpath("(//div[@class='control'])[3]//input")).sendKeys("pawan.bokoliaqa@gmail.com");
		driver.findElement(By.xpath("(//div[@class='control'])[4]//input")).sendKeys("test");
		
		driver.findElement(By.xpath("(//div[@class='control'])[5]//input")).sendKeys("test");
		driver.findElement(By.xpath("(//div[@class='control'])[6]//input")).sendKeys("test");
		driver.findElement(By.xpath("(//div[@class='control'])[7]//input")).sendKeys("test");
		
		driver.findElement(By.xpath("//div[@class=\"control _with-tooltip\"]//textarea")).sendKeys("this is for testing ");
		driver.findElement(By.xpath("(//div[@class='control'])[8]//input[1]")).click();
		driver.findElement(By.xpath("(//div[@class='control'])[9]//input")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
