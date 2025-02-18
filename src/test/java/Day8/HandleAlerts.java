package Day8;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver= new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			driver.manage().window().maximize();
			
/*			//1)Normal alert with ok button 
			driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
			
			Thread.sleep(5000);
			
		//	driver.switchTo().alert().accept(); 	 //this command use to accept the aleart 
			
			Alert myalert=driver.switchTo().alert();
			System.out.println(myalert.getText());
			myalert.accept();

			
			//confirmation Alert - ok and cancel 
			driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
			Thread.sleep(5000);
			//driver.switchTo().alert().accept();
			driver.switchTo().alert().dismiss();
*/			
			
			//3)Promt alert input box 
			driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
			Alert mypromtAlert =driver.switchTo().alert();
			mypromtAlert.sendKeys("welcome");
			mypromtAlert.accept();
			
			
			

	}

}
