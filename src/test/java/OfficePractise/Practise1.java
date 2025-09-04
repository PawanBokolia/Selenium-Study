package OfficePractise;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Practise1 {

		@Test
		public void screenshot() {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://flags.softdemonew.info/standard-custom-flags");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File sc = ts.getScreenshotAs(OutputType.FILE);
		File tg = new File(System.getProperty("user.dir")+"\\Screenshots\\test.png");
		sc.renameTo(tg);
		
		
		
		
	}

}
