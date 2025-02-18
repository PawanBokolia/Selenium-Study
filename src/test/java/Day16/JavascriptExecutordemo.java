package Day16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutordemo {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	//ChromeDriver driver=new ChromeDriver();		//approch2 
	
	
	
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.manage().window().maximize();
	
	
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	//JavascriptExecutor js= driver;						//approch2

	
	//passing the text into the input box - alternative of the sendkeys method
	WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));
	js.executeScript("arguments[0].setAttribute('value','pawan')",inputbox );   	
	
	
	//clicking on the element -- alternative of the click() action
	WebElement radiobutton= driver.findElement(By.xpath("//input[@id='male']"));
	js.executeScript("arguments[0].click()", radiobutton);
	

	
	
	}

}
