package Practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practise2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.scentperfique.com/");
		List<WebElement>  links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement x : links)
		{
			System.out.println(x);
		}

		driver.quit();
	}
}