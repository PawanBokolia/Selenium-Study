package Day7;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrwoserWindows {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs=driver.getWindowHandles();
		
		//Approach 1 
/*		
		//Switch to child 
		List <String> windowList=new ArrayList(windowIDs);
		String parentID=windowList.get(0);
		String childID=windowList.get(1);
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		
		//Switch to parent
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
*/		
		
		//Approach 2 
		
		for(String windids:windowIDs)
		{
			String title=driver.switchTo().window(windids).getTitle();
			if (title.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
			}
		}
		
		
		
		
		
	}

}
