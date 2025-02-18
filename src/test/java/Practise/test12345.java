package Practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test12345 {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\testautomation.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int trow = sheet.getLastRowNum();
		int tcolmn = sheet.getRow(1).getLastCellNum();

		for (int r=1; r<= trow; r++)
		{
			XSSFRow crrow = sheet.getRow(r);
			for (int c = 0; c < tcolmn; c++) 
			{
				XSSFCell ccell = crrow.getCell(c);
				System.out.println(ccell.toString());
			}
			workbook.close();
			file.close();

		}

	}
}
