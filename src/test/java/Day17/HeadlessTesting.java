	package Day17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new"); 		 //setting for headless mode of execution
		
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://demo.opencart.com/");
		
		String act_title=driver.getTitle();

		System.out.println(act_title);
		
		if (act_title.equals("Your Store"))
				{
				System.out.println("test pass ");
				}
				else{
					System.out.println("test fails ");
				}
	//	driver.quit();
			
		
		
		
	}

}
