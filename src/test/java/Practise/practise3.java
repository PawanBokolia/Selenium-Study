package Practise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practise3 {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.linkText("Selenium in biology")).click();
		driver.findElement(By.linkText("Selenium (software)")).click();
		driver.findElement(By.linkText("Selenium disulfide")).click();
		driver.findElement(By.linkText("Selenium dioxide")).click();
		
	
/*		Set<String> windowids = driver.getWindowHandles();
		for (String windid:windowids) {
			String title = driver.switchTo().window(windid).getTitle();
			if (title.equals("Selenium dioxide - Wikipedia") || title.equals("Selenium - Wikipedia")) {
				driver.close();
			}
		}
*/
		Set<String> windowids=driver.getWindowHandles();
		List<String> windowlist=new ArrayList (windowids);
		String a=windowlist.get(0);
		String b=windowlist.get(1);
		String c=windowlist.get(2);
		String d=windowlist.get(3);
		String e=windowlist.get(4);
		
		
		
		driver.switchTo().window(a).close();
		
	}

}
