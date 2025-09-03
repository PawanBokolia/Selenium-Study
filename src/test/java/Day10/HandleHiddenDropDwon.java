package Day10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleHiddenDropDwon {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//login steps 
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//click on pim
		driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']//span")).click();
		
		//click on dropdown 
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
		
		//select sigle option 
//		driver.findElement(By.xpath("//form//div[10]//span[1]")).click();
	
		Thread.sleep(6000);
		
		//count number of option 
		List <WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("number of options "+options.size());
		
		//print option 
		for(WebElement op:options) {
			System.out.println(op.getText());
		}
		
		
	}

}
