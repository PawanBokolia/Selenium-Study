	package Day1;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;

public class FirstseleniumScript {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jerrysartarama.com/");
		
		String act_title=driver.getTitle();

		System.out.println(act_title);
		
		if (act_title.equals("Art Supplies and Materials | Jerry's Artarama"))
				{
				System.out.println("test pass ");
				}
				else{
					System.out.println("test fails ");
				}
		driver.quit();
		
		
		
		
	}

}
