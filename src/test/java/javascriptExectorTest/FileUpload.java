package javascriptExectorTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//single file upload
		driver.findElement(By.xpath("//input[@id='filesToUpload']"))
							.sendKeys("E:\\Personal\\List of Public Holidays_2025-Hepto Technologies.pdf");
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().equals
				("List of Public Holidays_2025-Hepto Technologies.pdf")) {
			System.out.println("File is succesfully uploaded");
		}else {
			System.out.println("Upload failed");
		}
		
		
		//multiple file upload
		String file1="E:\\Personal\\List of Public Holidays_2025-Hepto Technologies.pdf";
		String file2="E:\\Personal\\jayabal resume.pdf";
		
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		int noofFilesupload= driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();
		
		if(noofFilesupload==3) {
			System.out.println("All files are uploaded");
		}else {
			System.out.println("Files are not uploaded or incorrect files uploaded");
		}
		
		//validate file names
			
		//validate file name
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("List of Public Holidays_2025-Hepto Technologies.pdf") 
				&& driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("List of Public Holidays_2025-Hepto Technologies.pdf")) {
			System.out.println("Files names matching");
		}
		else {
			System.out.println("file names or not matching");
		}

	}

}
