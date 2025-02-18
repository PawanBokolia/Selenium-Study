package Day15;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpentheLinkInAnotherTab {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		WebElement registrationlink =driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions act=new Actions (driver);
		
		//Control+click
		act.keyDown(Keys.CONTROL).click(registrationlink).keyUp(Keys.CONTROL).perform();

		//switching to registration 
		List<String> ids=new ArrayList(driver.getWindowHandles());
		
		//Registration page 
		driver.switchTo().window(ids.get(1));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("pawan");
		
		//Home page 
		driver.switchTo().window(ids.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Tshirt");
		
	

	}

}
