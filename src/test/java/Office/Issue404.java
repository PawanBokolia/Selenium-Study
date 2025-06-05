package Office;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilities.ExcelUtility;

public class Issue404 {

	public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
		String path = ".//testdata//new_404.xlsx";
		ExcelUtility util = new ExcelUtility(path);

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(option);
		
		
		int rowCount = util.getRowCount("Sheet1");

		for (int i = 1; i < rowCount; i++) 
		{
			String url = util.getCellData("Sheet1", i, 0);

//			driver.get(url);
//			Thread.sleep(2000);
			
			URL linkURL = new URL(url);
			
			HttpURLConnection conn =(HttpURLConnection) linkURL.openConnection();
			conn.setRequestMethod("HEAD"); 
			conn.connect();
			int response = conn.getResponseCode();
	
			String responseInString = Integer.toString(response);
			
			if(response>=400)
			{
				System.out.println("redirect to "+linkURL +"  " +response);
				util.setCellData("Sheet1", i, 1, responseInString );
			}
			
			else 
			{
				System.out.println("redirect to correct");
				util.setCellData("Sheet1", i, 1, responseInString );
			}
			
		}

		driver.quit();



	}

}
