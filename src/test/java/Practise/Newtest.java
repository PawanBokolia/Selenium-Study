package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Newtest {

	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://templates.newsoftdemo.info/hotels/puro/saulo-by-puro.html");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='icon-6'])[2]"))).click();
		
		
		
		
		
		
		
		
	}
}
