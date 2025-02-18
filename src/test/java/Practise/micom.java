package Practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class micom {

	WebDriver driver;
	
	@BeforeClass
	void setup() 
	{
		driver = new ChromeDriver();
		driver.get("https://fw3.softdemonew.info/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test
	void clickonmenu()
	{
		List<WebElement> menu=driver.findElements(By.xpath("https://fw3.softdemonew.info/"));
		for(WebElement a: menu) {
			a.click();
			driver.navigate().back();
		
		}
	}
}
