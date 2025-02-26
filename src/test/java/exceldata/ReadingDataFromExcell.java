package exceldata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcell {

	//excel file-->workbook-->sheets-->rows-->cells
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\sheet1.xlsx");	
		//FileInputStream file=new FileInputStream	("C:\\Users\\jayab\\eclipse-workspace\\demoone\\testdata\\sheet1.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=  workbook.getSheet("sheet1");      //XSSFSheet sheet1=workbook.getSheetAt(0);
		int totalRows=sheet.getLastRowNum();
		
		int totalCells= sheet.getRow(1).getLastCellNum();
		System.out.println("number of rows:"+totalRows);
		System.out.println("number oof cells: "+totalCells);
		
		for(int r=0;r<=totalRows;r++) {
			
			XSSFRow currentRow=sheet.getRow(r);
			
			for (int c=0;c<totalCells;c++){
				XSSFCell cell= currentRow.getCell(c);
				System.out.println(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		

	}

}
