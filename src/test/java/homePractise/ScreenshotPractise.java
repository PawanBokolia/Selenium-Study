package homePractise;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenshotPractise {

	@Test
	public void screenshot() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.get("https://google.com/");
		
		WebElement a =driver.findElement(By.cssSelector("div[aria-label=\"Search by voice\"]"));

		File abe =a.getScreenshotAs(OutputType.FILE);
		File nw = new File (System.getProperty("user.dir")+"\\Sceenshots\\p.png");
		FileUtils.copyFile(abe, nw);
		
		
	
	}
}