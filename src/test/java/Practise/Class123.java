package Practise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class123 {

	public static void main (String args[]) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("");
		
		Runtime.getRuntime().exec("");
		
		
		
		
		
		
		
		
		
		
		
	}
}
