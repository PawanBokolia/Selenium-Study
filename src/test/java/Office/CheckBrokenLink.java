package Office;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBrokenLink {

	public static void main(String ars[]) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://flags.co.uk/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total number of links " + links.size());
		
		int noOfBrokenlink=0;
		for (WebElement linkelement : links)
		{
			String hrefattvalue = linkelement.getAttribute("href");
			if (hrefattvalue == null || hrefattvalue.isEmpty() || hrefattvalue == "https://flags.co.uk/#") 
			{
				System.out.println("href attribute value is null or empty os not possible to check");
				System.err.println(hrefattvalue);
				continue;
			}

			// Hit url to the server

			try {
				
				URL linkURL=new URL(hrefattvalue);											// CONVERTED href VALUE FROM STRING TO URL FORMAT
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();		 // OPEN CONNECTION TO THE SERVER
				
				conn.setRequestMethod("HEAD"); 												//check only head
				conn.connect(); 															// connect to server and request to server
				
				int response = conn.getResponseCode();
				
				if ( response >= 400 ) 
				{
					System.err.println("broken link====> "+hrefattvalue +"   "+response);
					noOfBrokenlink++;
				}
				else 
				{
					System.out.println("Not a broken link======> "+hrefattvalue +"      " +response);
				}

			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("number of broken links "+noOfBrokenlink);
		
		
		
		
	}
}
