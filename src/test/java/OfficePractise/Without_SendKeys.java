package OfficePractise;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Without_SendKeys {

	public static void main (String args[]) throws InterruptedException, IOException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://jerrysartarama.com/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.xpath("(//button[@data-action=\"customer-menu-toggle\"])[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//li[@class=\"link authorization-link\"])[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("pawan.bokoliaqa@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("pawan@95");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class=\"action login primary\"]")).click();
		
		Thread.sleep(3000);
		driver.navigate().to("https://www.jerrysartarama.com/favorites/list/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form[@action=\"https://www.jerrysartarama.com/favorites/list/importcsv/\"]//button"))
	      .click();
	
		StringSelection filePath = new StringSelection(System.getProperty("user.dir")+"\\testdata\\teacherwishlist.csv");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		
		
	}
}