package Day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
/*		//single file upload---pawan1
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("D:\\testing\\pawan1.txt");
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("pawan1.txt"))
		{
			System.out.println("file upload sucessfully ");
		}
		else
		{
			System.out.println("upload fail");
		}
		
		//upload multiple files ---pawan1 and pawan2
*/	
		String file1="D:\\testing\\pawan1.txt";
		String file2="D:\\testing\\pawan2.txt";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		int nooffileuploaded=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		
		if(nooffileuploaded==2)
		{
			System.out.println("all file are uploaded ");
		}
		else 
		{
			System.out.println("incorrect files uploaded ");
		}
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("pawan1.txt") &&
		driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("pawan2.txt"))
		{
			System.out.println("file name is matching");
		}
		else
		{
			System.out.println("file name is not matching");
		}
	
	
	}

}
