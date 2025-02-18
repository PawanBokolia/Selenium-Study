package Practise;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Day20.ExcelUtils;

public class Redirects {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriver driver= new ChromeDriver (options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\request_target.xlsx";
	
		int rows = ExcelUtils.getRowCount(filePath, "request_target");
		System.out.println(rows);
				
				// hitting  the URL from row 2 
				for(int i =1 ; i<=rows; i++) {
				
				 String URL = ExcelUtils.getCellData(filePath, "request_target", i, 0);			
				 System.out.println(URL);
				 
				 try {
						driver.get(URL);
				 	}
				
				 catch(Exception e )
				{
					System.out.println("too many request");
					Thread.sleep(50000);
				}
				 
				 // writing the URL in the sheet at 3rd column 
				 String Redirect = driver.getCurrentUrl();
				 ExcelUtils.setCellData(filePath, "request_target", i, 2, Redirect);
				 
				 String targetURL=ExcelUtils.getCellData(filePath, "request_target", i, 1);	
				
				 
				 //redirect test is pass or fail 
				 if(targetURL.equals(Redirect)) 
				 {
					 ExcelUtils.setCellData(filePath, "request_target", i, 3, "Test Pass");
				 }
				 
				 else
				 {
					 ExcelUtils.setCellData(filePath, "request_target", i, 3, "Test Fails");
				 }
				
			}
	
			System.out.println("task complete");
	}

}
