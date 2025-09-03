package Day11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1)find total number of rows in table 
		int row =driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("number of rows are "+ row); //7
		
		//another approach 
//		int row =driver.findElements(By.tagName("tr")).size();
//		System.out.println("number of rows are "+ row);		//14		   //it will calculate all rows of the page 
		
		//2 find total number of column in a table 
		int column = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("number of coloun " +column);  //4
	
		//another approach is same as above 
		
		//3) read data from specific row and column (ex: 5th row and 1st column )
//		String bookname=driver.findElement(By.xpath("//table[@name='BookTable'] //tr[5]//td[1]")).getText();
//		System.out.println(bookname);
		
/*		//4)read data from all the rows and column 
	for (int r=2;r<=row;r++)
		{
			for(int c=1;c<=column;c++)
			{
				String value =driver.findElement(By.xpath("//table[@name='BookTable'] //tr["+r+"]//td["+c+"]")).getText();  	//passing variable into x path 
				System.out.print(value+"\t");
			}
			System.out.println();
		}

		//5)print book name whose auther is mukesh 
		
		for(int r=2;r<=row;r++) {
			String authorname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(authorname.equals("Mukesh")) 
			{
				String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookname+"\t"+authorname);
			}
	}
*/
	
		int total=0;
		for(int r=2;r<=row;r++)
		{
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			//System.out.println(price);
			total=total+Integer.parseInt(price);
		}
		
		System.out.println("Total price of the book is "+total);
		
	
		
		
	}

}
