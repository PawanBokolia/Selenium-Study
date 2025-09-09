package homePractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class Verify_test {

	@Test(retryAnalyzer =RetryAnalyzer.class)
	public void test() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://mrd.softdemonew.info/o-scale/locomotives-oo-scale/diesel-electric-locomotives-oo-scale/diesel-electric-locomotives-oo-scale.html");
	
	Actions act = new Actions(driver);
//	WebElement a = driver.findElement(By.xpath("(//a[@class=\"mpquickview-button\"])[1]"));
	
	driver.findElement(By.xpath("(//a[text()='Digital Train Sets'])[2]")).click();	
	
	
	
}
}