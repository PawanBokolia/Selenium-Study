package LoveBrewing;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePagetest {

	WebDriver driver;
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://stage.lovebrewing.co.uk/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@Test
	void clickfunc() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		
		
	}
	
	@AfterClass
	void close()
	{
		driver.quit();
	}
	
	
	
}
