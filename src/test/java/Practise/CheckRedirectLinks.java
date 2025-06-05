package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckRedirectLinks {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Set up Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Increase timeout to wait for page load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        // Path to your Excel file
        String excelFilePath = "D:\\Workspace\\Untitled spreadsheet.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);

        // Open the Excel file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

        // Loop through all the rows in the Excel sheet
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Skip header row

            // Get the source and expected redirect links from the Excel
            String sourceLink = row.getCell(0).getStringCellValue(); // Assuming link to check is in column 0
            String expectedRedirect = row.getCell(1).getStringCellValue(); // Assuming expected link is in column 1

            // Open the source link in the browser
            driver.get(sourceLink);
           
            // Get the current URL after possible redirection
            String currentUrl = driver.getCurrentUrl();

            // Compare the actual redirected URL with the expected one
            if (currentUrl.equals(expectedRedirect)) {
                System.out.println("PASS: " + sourceLink + " redirected to " + currentUrl);
            } else {
                System.out.println("FAIL: " + sourceLink + " redirected to " + currentUrl + ", expected: " + expectedRedirect);
            }
            
            Thread.sleep(10000);
            
            
        }

        // Close workbook and browser
        workbook.close();
        fileInputStream.close();
        driver.quit();
    }
}

