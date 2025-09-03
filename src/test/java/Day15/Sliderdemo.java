package Day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sliderdemo {
	public static void main (String[]agrs ) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//minimum slider 
		WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Deault location of the min slider "+min_slider.getLocation()); 			 	 //x(59) y(250)			//getY and GetX is used to move 
		act.dragAndDropBy(min_slider, 100, 250).perform();
		
		System.out.println("location of the min slider after moving "+min_slider.getLocation());
		
		//maximum slider 
		WebElement max_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
		System.out.println("Deault location of the max slider "+max_slider.getLocation());	 			  //x(766) y(250)			//getY and GetX is used to move 
		act.dragAndDropBy(max_slider, -66, 250).perform();	
		
		System.out.println("location of the max slider after moving "+max_slider.getLocation());
		
		
		
		
	}
}
