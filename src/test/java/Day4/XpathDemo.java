package Day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main (String []args ) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
/*		//Xpath with single attribute
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("tshirt");
		
		
		
		//Xpath with multiple attribute 
		driver.findElement(By.xpath("//input[@name='search'][@placeholder='Search']"));
		
		
		//Xpath 'and' 'or' operator 
		//input[@placeholder='Search' and @name='search']   //both should be matched 
		//input[@placeholder='Search' or @name='search']    // one should be matched
		
		
		//and operator 
		driver.findElement(By.xpath("//input[@placeholder='Search' and @name='search']")).sendKeys("Tshir");
		
		
		//or operator
		driver.findElement(By.xpath("//input[@placeholder='Search' or @name='search']")).sendKeys("Tshirt");
	
		
		//xpath with inner text  - text()
		driver.findElement(By.xpath("//*[text()='MacBook']")).click();
			
		
	    boolean displaystatus =	driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
		System.out.println(displaystatus);
		
		
	    String value =	driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
	    System.out.println(value);
	    
	    
	    // xpath with contains()
	    driver.findElement(By.xpath("//input[contains(@placeholder,'Sea')]")).sendKeys("Tshirt");     //it can be used in middle of the attribute and anywhere else  
	    
	    
	    //xpath with starts-with 
	    driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sea')]")).sendKeys("Tshirt");  // it work at start 
		
		
		//chained xpath
		boolean imagestatus=driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();     // /a/img is used for chained xpath 
		System.out.println(imagestatus);
		
*/		
		
	}
}
