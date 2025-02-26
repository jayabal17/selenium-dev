package dataDriven_testing;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutls {
	public static FileInputStream fi;
	public static FileOutputStream f0;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
			public static int getRowcount(String xlfile,String xlsheet) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				int rowCount=ws.getLastRowNum();
				wb.close();
				fi.close();
				return rowCount;
				
			}
			public static int getcellCount(String xlfile,String xlsheet,int rownum) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				int cellcount=row.getLastCellNum();
				wb.close();
				fi.close();
				return cellcount;
				
			}
			
			public static String getcellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell=row.getCell(colnum);
				
				String data;
				try
				{
					data=cell.toString();
					DataFormatter formatter=new DataFormatter();
					data=formatter.formatCellValue(cell);    //returns the formatted value of a cell as a string regardless of the cell type
					
				}
				catch(Exception e)
				{
					data="";
				}
			wb.close();
			fi.close();
			return data;
				
				
			}
			
			public static void setcelData(String xlfile,String xlsheet,int rownum,int colnum,String data)throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell.setCellValue(data);
				f0=new FileOutputStream(xlfile);
				wb.write(f0);
				wb.close();
				fi.close();
				f0.close();
			}
	
	        
			public static void fillGreen(String xlfile,String xlsheet,int rownum,int colnum)throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell=row.getCell(colnum);
				
				style=wb.createCellStyle();
				
				style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				
				cell.setCellStyle(style);
				f0=new FileOutputStream(xlfile);
				wb.write(f0);
				wb.close();
				fi.close();
				f0.close();
			}
			
			public static void fillRed(String xlfile,String xlsheet,int rownum,int colnum)throws IOException
			{
				fi=new FileInputStream(xlfile);
				wb=new XSSFWorkbook(fi);
				ws=wb.getSheet(xlsheet);
				row=ws.getRow(rownum);
				cell=row.getCell(colnum);
				
				style=wb.createCellStyle();
				
				style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				
				cell.setCellStyle(style);
				f0=new FileOutputStream(xlfile);
				wb.write(f0);
				wb.close();
				fi.close();
				f0.close();
				
			}
			
			
	
}

