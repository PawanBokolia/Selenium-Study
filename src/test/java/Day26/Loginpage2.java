package Day26;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage2 {
	WebDriver driver;
	//constructor
	Loginpage2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
/*	By username_locator = By.xpath("//input[@placeholder='username']");
	By userpass_locator = By.xpath("//input[@placeholder='password']");
	By btn_locator = By.xpath("//button[normalize-space()='Login']");
*/
	@FindBy(how=How.XPATH,using = "//input[@placeholder='username']")  			//another approach  
	WebElement txt_username;
	
	@FindBy(xpath = "//input[@placeholder='password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btn_login;
	
	
	
	//Action methods
	public void setusername(String user)
	{
		 txt_username.sendKeys(user);
	}
	
	public void setpassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		 btn_login.click();
	}
	

}
