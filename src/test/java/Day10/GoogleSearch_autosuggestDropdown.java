package Day10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch_autosuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	
	driver.findElement(By.name("q")).sendKeys("selenium");
	
	Thread.sleep(5000);
	
	List <WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@role='option']"));
	
/*	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().equals("selenium"));
		{
			list.get(i).click();
			break;
		}
	}
*/	
	//approach 2 
	for(WebElement list1:list ) {
		if(list1.getText().equals("selenium")) {
			list1.click();
			break;
		}
	}
	

	}

}
