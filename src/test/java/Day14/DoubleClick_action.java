package Day14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick_action {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame("iframeResult");
		
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		box1.clear();
		box1.sendKeys("pawan");
		
		//double click on the button 
		Actions act=new Actions(driver);
		act.doubleClick(button).perform();
		
		//validation: box 2 should contain "pawan"
		String text=box2.getAttribute("value");   //box2.getText();   //new function using for getting value when gettext is not working 
		
		System.out.println("value is "+text);				  //checking why value is not copied via getText()
		
		if(text.equals("pawan"))
		{
			System.out.println("text is copied ");
		}
		else
		{
			System.out.println("text not copied");
		}
		
		
	}

}
