package Day19;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	//Excel file---->workbook----->Sheet--->row--->cell
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testautomation.xlsx");  //(System.getProperty("user.dir") -->current project location 
		XSSFWorkbook workbook = new XSSFWorkbook (file);
		XSSFSheet sheet =workbook.getSheet("Sheet1");   			  //XSSFSheet Sheet = workbook.getSheetAt(0);
		
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(1).getLastCellNum();   			//you can take zero also instead of 1 
		
		System.out.println("number of rows " +totalRows);			//5 read from zero
		System.out.println("number of cells " +totalCells);			//4 read from one
		
		for(int r=1;r<=totalRows;r++) 
		{
			XSSFRow  currentRow = sheet.getRow(r);
			
			for(int c=0;c<totalCells;c++)
			{
				XSSFCell cell=currentRow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		workbook.close();
		file.close();
		
		}

	
	}
}

