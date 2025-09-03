package Day17;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturesScreenshots {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

/*		// 1)Full page screenshots
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File tragetfile =new File(System.getProperty("user.dir")+"\\Sceenshots\\fullpage.png");  //D:\Workspace\20 march 2023\SeleniumWebDriver\Sceenshots    //original  path 
		sourcefile.renameTo(tragetfile);  	//copy source file to target file 
		
		//2) Capturing the Screen shot of a specific sections 
		
		WebElement featureproduct=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File sorcefile=featureproduct.getScreenshotAs(OutputType.FILE);
		File tragetfile =new File(System.getProperty("user.dir")+"\\Sceenshots\\featureproducts.png");
		sorcefile.renameTo(tragetfile); 
*/
		
		// 3) capture the Screenshot of web element 
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourcefile=logo.getScreenshotAs(OutputType.FILE);
		File tragetfile =new File(System.getProperty("user.dir")+"\\Sceenshots\\logo.png");
		sourcefile.renameTo(tragetfile);
		
		driver.quit();
		
		
		
		
	}
}
