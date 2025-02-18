package Practise;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Practise1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		 driver.get("https://stage.magee1866.com/");
		 driver.manage().window().maximize();
		List<WebElement> headerlinks =driver.findElements(By.className("cmsb2-text-black"));
		for(WebElement x:headerlinks) 
		{
			System.out.println("name of Links are "+ x);
		}
		
			System.out.println("number of count of links are " +headerlinks.size());

	}

}
