package Day20;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver= new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\DataDiven.xlsx";
		
		int rows=ExcelUtils.getRowCount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//read data from excel
			String pric = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateofinterest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String per1 = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String per2 = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);
			String fre = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);
			String exp_mvalue = ExcelUtils.getCellData(filePath,"Sheet1", i,5);
			
			//pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(pric);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			
			Select perdrp = new Select (driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			perdrp.selectByVisibleText(per2);
			
			Select fredrp = new Select (driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(fre);
			
			WebElement click=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			js.executeScript("arguments[0].click();", click);
			
			
			//validation
			String act_mvalue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(exp_mvalue) == Double.parseDouble(act_mvalue)) 
			
			{
				System.out.println("test pass");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "passed");
			}
			else
			{
				System.out.println("test failed");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "failed");
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();   //Clicked on clear button 
			
		}		//ending of the for loop 
		
		
			driver.close();

	}

}
