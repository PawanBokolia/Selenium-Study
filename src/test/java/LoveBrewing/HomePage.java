package LoveBrewing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	//constructor
	WebDriver driver;
	HomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	//locator

		//feature product
		By featureproduct1 = By.xpath("//a[@class='second owl-home-nav-tab2']");
		By featureproduct2 = By.xpath("//a[@class='third owl-home-nav-tab3']");
		By featureproduct3 = By.xpath("//a[@class='third owl-home-nav-tab4']");
		By featureproduct4= By.xpath("//a[normalize-space()='Presses & Crushers']");


		//tiles
		By tiles1 = By.xpath("//a[normalize-space()='Go to guides']");
		By tiles2 = By.xpath("//a[normalize-space()='Watch video']");
		By titles3 = By.xpath("//a[normalize-space()='Starter bundles']");
	
		//banner 
		By bannerbtr = By.xpath("//a[normalize-space()='Next']");
		By bannerbtl = By.xpath("//a[normalize-space()='Next']");

		
		public void clickonfeature() throws InterruptedException
		{
			driver.findElement(featureproduct1).click();
		}
		
		public void clickonfeature2() 
		{
			driver.findElement(featureproduct2).click();
		}
		
		public void clickonfeature3()
		{
			driver.findElement(featureproduct3).click();
		}
		
		public void clickonfeature4()
		{
			driver.findElement(featureproduct4).click();
		}
		
		public void bannerclick() {
			Actions act = new Actions (driver);
			act.moveToElement(driver.findElement(bannerbtr)).click().perform();
		}
		
		public void bannerclick2() {
			Actions act = new Actions (driver);
			act.moveToElement(driver.findElement(bannerbtl)).click().perform();
		}
		
		



}

