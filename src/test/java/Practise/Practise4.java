package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise4 {
	public static void main (String [] agrs) {
		WebDriver driver= new ChromeDriver();
		//WebDriverWait mywait= new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.get("https://m2dev.jerrysartarama.com/matisse-structure-acrylic-colors");

		/*		List <WebElement>  size = driver.findElements(By.xpath("//span[@class='size-values display-value size-changes' and @data-ml='150 ML']"));
		for (WebElement a: size ) {
		System.out.println(a.isDisplayed());
		System.out.println(a.getSize());
			//System.out.println(a.getText());
		}
*/
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//div[@aria-controls='image-tab']//a")).click();
		boolean a= driver.findElement(By.xpath("//div[@aria-controls='image-tab']//a")).isDisplayed();

		driver.findElement(By.xpath("//div[@aria-controls='description']//a")).click();
		boolean b=driver.findElement(By.xpath("//div[@aria-controls='description']//a")).isDisplayed();
		
		driver.findElement(By.xpath("//div[@aria-controls='video-tab']//a")).click();
		boolean c=driver.findElement(By.xpath("//div[@aria-controls='description']//a")).isDisplayed();
		
		driver.findElement(By.xpath("//div[@aria-controls='reviewdisplay.tab']//a")).click();
		boolean d=driver.findElement(By.xpath("//div[@aria-controls='reviewdisplay.tab']//a")).isDisplayed();
	
	
				
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

		
		
		
		
		
		
		
		
		
		
	}
			
}
