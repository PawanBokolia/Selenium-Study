package Office;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.ExcelUtility;

public class RedirectCheck {

	public static void main(String[] args) throws IOException, InterruptedException {

		String path = ".//testdata//Gaugemaster.xlsx";
		ExcelUtility util = new ExcelUtility(path);

		WebDriver driver = new ChromeDriver();
		int rowCount = util.getRowCount("Sheet1");

		for (int i = 1; i < rowCount; i++) 
		{
			String url = util.getCellData("Sheet1", i, 0);
			driver.get(url);

			Thread.sleep(4000);

			String currentUrl = driver.getCurrentUrl();
			System.out.println("Writing URL to Excel: " + currentUrl);


			String expectedURL = util.getCellData("Sheet1", i, 1);

			if(expectedURL.equals(currentUrl))
			{
				util.setCellData("Sheet1", i, 2, currentUrl);
			}

		}

		driver.quit();












	}

}
