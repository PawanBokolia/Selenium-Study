package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
/*		
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		
		
		//isDisplayed
	//	WebElement logo= driver.findElement(By.xpath("//img[@title='nopCommerce']"));
	//	System.out.println("Display status of logo " +logo.isDisplayed());
		
		//another way
		Boolean status =driver.findElement(By.xpath("//img[@title='nopCommerce']")).isDisplayed();
		System.out.println("Display ststus is " +status);

		
		//isEnable
		driver.get("https://demo.nopcommerce.com/register");
		Boolean status=driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).isEnabled();
		System.out.println("Enable status" +status);
*/		
		driver.get("https://demo.nopcommerce.com/register");
		//isSelected 
		WebElement male_rd =driver.findElement(By.xpath("//input[@value='M']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@value='F']"));
		
		System.out.println("before selecting....... ");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		System.out.println("after selecting ........");
		male_rd.click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		
		
		
		
		
		
		
		
		
	}

}
