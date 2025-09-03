package Day8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

			// 1)select specific check box
//  		driver.findElement(By.xpath("//input[@id='monday']"));

			// 2) select all the check box
			List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
			for(int i =0; i<checkboxes.size() ; i++) 
			{ 
				checkboxes.get(i).click();
			}
		  
		 
			// another Approach
			for (WebElement checkbox : checkboxes)
			{ 
				checkbox.click();
			}
		  
		  
			//3) select last 3 check boxes
			for(int i=4;i<checkboxes.size();i++) 
		  {
			  checkboxes.get(i).click(); 
		  }
		 

			// 4)select first 3 Check boxes
			for (int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}

		Thread.sleep(5000);

			// 5) unselect check box if they are selected
			for (int i = 0; i < checkboxes.size(); i++) {
			if (checkboxes.get(i).isSelected())
			{
				checkboxes.get(i).click();
			}
		}
		
		
		

	}

}
