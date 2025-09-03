package Day9;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrame {
	public static void main (String [] args ) {
		WebDriver driver= new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
			
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//Frame1
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);     			//passes frame as webelement   //switch to fame 1
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
		
		driver.switchTo().defaultContent();  		//use this to go to default page //come back to page 
		
		//Frame2 
		WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);  			//if id and name is present put it in the "" ex- driver.switchTo().frame("name/id");
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("selenium");
		
		driver.switchTo().defaultContent(); 	//important as we go back to previous/first frame 
		
		//Frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("java");
		
		//inner iframe -part of frame3
		driver.switchTo().frame(0);  			//switching to fame usning index 
		driver.findElement(By.xpath("//div[@aria-label='I am a human']")).click();
		
		
		
		
		
		
		
		
		
		
	}
}
