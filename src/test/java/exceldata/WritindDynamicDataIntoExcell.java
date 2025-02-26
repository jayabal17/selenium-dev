package exceldata;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritindDynamicDataIntoExcell {

    public static void main(String[] args) throws IOException {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Ask user for the number of rows
        System.out.println("Enter how many rows?");
        int noOfRows = sc.nextInt();

        // Ask user for the number of cells per row
        System.out.println("Enter how many cells?");
        int noOfCells = sc.nextInt();

        // File location to save the Excel file
        String filePath = System.getProperty("user.dir") + "\\testdata\\myfile_dynamic.xlsx";
        FileOutputStream file = new FileOutputStream(filePath);

        // Create a workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DynamicData");

        // Loop to create rows and cells dynamically
        System.out.println("Enter data for each cell:");
        for (int r = 0; r < noOfRows; r++) {
            XSSFRow currentRow = sheet.createRow(r);

            for (int c = 0; c < noOfCells; c++) {
                System.out.printf("Enter value for Row %d, Cell %d: ", r + 1, c + 1);
                String cellValue = sc.next(); // Read cell value
                XSSFCell cell = currentRow.createCell(c);
                cell.setCellValue(cellValue);
            }
        }

        // Write data to file and close resources
        workbook.write(file); // Attach workbook to the file
        workbook.close();
        file.close();
        sc.close();

        System.out.println("\nFile is created successfully at: " + filePath);
    }
}