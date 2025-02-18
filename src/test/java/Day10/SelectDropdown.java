package Day10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpcountryele= driver.findElement(By.xpath("//select[@id='country']"));
		
		Select drpCountry=new Select (drpcountryele);
		
		//select option from the drop down 
//		drpCountry.selectByVisibleText("France");
		
		//select by value 
//		drpCountry.selectByValue("japan");
		
		//select by index //for this you have to count it 
		drpCountry.selectByIndex(2);
		
		//capture the options from the dropdown
		List <WebElement>options=drpCountry.getOptions();
		System.out.println("number of options in a dropdown "+options.size());
		
		//printing the options //approach 1 
//		for (int i=0; i<options.size();i++) {
//			System.out.println(options.get(i).getText());
//		}
		
		//print the option //approach 2 enhanced for loop 
		for(WebElement op:options) {
			System.out.println(op.getText());
		}
		
		
		
		
	}

}
