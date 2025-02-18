package Practise2;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practise1 {
	
	public static void main (String args []) throws IOException {
		String path1=System.getProperty("user.dir")+"\\testdata\\myfile.xlsx";
//		String path = ".\\testdata\\myfile.xlsx";
		
		FileInputStream file = new FileInputStream(path1);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Data");

		int rowno = sheet.getLastRowNum();
		int colno = sheet.getRow(1).getLastCellNum();
		
		for(int r =0; r<=rowno;r++)
		{
			XSSFRow currentrow=sheet.getRow(r);
			for(int c =0;c<colno;c++)
			{
				XSSFCell cell=	currentrow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
				System.out.println();
		}
		
		
		workbook.close();
		
		
		
		
		
		
	}
	
}
