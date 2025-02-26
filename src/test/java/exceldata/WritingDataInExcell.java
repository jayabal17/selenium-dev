package exceldata;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//excell file--->workbook--->sheets-->rows---->cells
		
        // Create an Excel file in the specified directory
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile.xlsx");
        
        // Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        // Create a sheet
        XSSFSheet sheet = workbook.createSheet("Data");
        
        // Create first row and set values
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Python");
        row1.createCell(1).setCellValue(1234);
        row1.createCell(2).setCellValue("Automation");
        
        // Create second row and set values
        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Java");
        row2.createCell(1).setCellValue(1234);
        row2.createCell(2).setCellValue("Automation");
        
        // Create third row and set values
        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("C#");
        row3.createCell(1).setCellValue(1234);
        row3.createCell(2).setCellValue("Automation");
        
        // Write data to file and close resources
        workbook.write(file);
        workbook.close();
        file.close();
        
        System.out.println("File is created successfully");
	

}
}
