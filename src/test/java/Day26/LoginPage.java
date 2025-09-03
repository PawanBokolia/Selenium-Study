package Day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	//constructor
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	By username_locator = By.xpath("//input[@placeholder='username']");
	By userpass_locator = By.xpath("//input[@placeholder='password']");
	By btn_locator = By.xpath("//button[normalize-space()='Login']");
	
	
	
	//Action methods
	public void setusername(String user)
	{
		driver.findElement(username_locator).sendKeys(user);
	}
	
	public void setpassword(String pwd)
	{
		driver.findElement(userpass_locator).sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		driver.findElement(btn_locator).click();
	}
	

	
	
	
}
