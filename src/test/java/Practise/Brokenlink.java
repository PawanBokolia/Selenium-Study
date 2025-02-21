package Practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Brokenlink {

	public static void main(String[] args) {

		// Set path to ChromeDriver executable
	//	System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

		// Initialize ChromeDriver
		WebDriver driver = new ChromeDriver();

		// Open the webpage
		driver.get("https://crosthwaiteandgardiner.com/");

		// Find all the links on the webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Iterate through each link
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				// Check if the link is broken
				if (checkLinkStatus(url)) {
					System.out.println("Broken Link: " + url);
				} else {
					System.out.println("Valid Link: " + url);
				}
			}
		}

		// Close the browser
		driver.quit();
	}

	// Function to check if a link is broken
	public static boolean checkLinkStatus(String url) {
		// Add code to check the link status (e.g., HTTP response code)
		// Return true if the link is broken, false otherwise
		return false;
	}

}
