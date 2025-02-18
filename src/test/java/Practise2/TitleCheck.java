package Practise2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TitleCheck {

	@Test(priority=1)
	public void megamenu() {

		
		WebDriver driver = new ChromeDriver();
		driver.get("https://m2stage.gaugemasterretail.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
	
		int b[] = {1,2,3,4,5,6,7};
		String titlearray[] = {"Candle Making Supplies Wholesale | Luxury Candle Making Supplies",
								"Private Label Candles UK | Candle Manufacturers | Wholesale Candles",
								"Wholesale Home Fragrance Supplies | Home Fragrance Manufacturers UK",
								"Fragrance Oils UK | Fragrance Oil Supplier | Candle Making Fragrance Oils",
								"Fragrance Delivery System | Scent Marketing | Scent Diffusers",
								"Wholesale Cosmetic Supplies | Cosmetic Ingredients | Bath & Body Products",
								"Wax Melt Supplies Wholesale UK | Wax Melt Supplier & Manufacturer"
								};
					
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Close dialog']"))).click();	
			
		
			
		
		SoftAssert soft = new SoftAssert();
		
		for(int i=0;i<b.length;i++)
		{
			WebElement a = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='level-0 flex items-center ransition transition-colors duration-500 group'])["+(i+1)+"]")));
			a.click();
			String sitetitle=driver.getTitle();
			soft.assertEquals(sitetitle, titlearray[i]);
		}
		
		soft.assertAll();
		
		
	}	
}