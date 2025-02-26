package demoone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		//1)Find total number of rows in table
		//table[@name="BookTable"]
		int rows= driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Number of rows:"+rows);

		//2)Find total number of rows in table
		int cols= driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of rows:"+cols);
		
		//3)Read data from specific row and column (ex:5th row)
		String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println(bookname);
		
		//4)read data from all the rows and column
		for (int r=2;r<=rows;r++) {
			for(int c=2;c<cols;c++) {
				driver.findElement(By.xpath("//table[@name='BookTable']//tr[r]//td[c]")).getText();
			}
		}

	}

}
