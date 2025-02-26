package exceldata;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dataDriven_testing.Excelutls;

public class testdummy {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.sbisecurities.in/calculators/fd-calculator");
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\caldatas.xlsx";
		
		int rows= Excelutls.getRowcount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//1)read data from excel
			String pric=  Excelutls.getcellData(filePath, "Sheet1", i, 0);
			String rateofinterest=  Excelutls.getcellData(filePath, "Sheet1", i, 1);
			String per1=  Excelutls.getcellData(filePath, "Sheet1", i, 2);
			String exp_mvalue= Excelutls.getcellData(filePath, "Sheet1", i,3 );
			
			//2)Pass above data into the application
			driver.findElement(By.xpath("//div[@class='input-group']//input[@id='input_fd_investment']")).sendKeys(pric);
			driver.findElement(By.xpath("//input[@id='input_interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//body/app-root/app-fd-calculator[@class='ng-star-inserted']/div[@class='container']/div[@class='col-md-12 pt-5 mt-5']/div[@class='row pdt-30']/div[@class='col-xl-9 col-lg-7 col-md-7']/div[@class='border']/form[@id='validForm']"
					              + "/div[@class='row mt-2 d-flex']/div[@class='form-group col-md-6 mb-3']/input[1]")).sendKeys(per1);
			
			Thread.sleep(3000);	
			  // Locate the dropdown element
	        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='frequency']")); // Change ID as needed

	        // Create a Select object
	        Select dropdown = new Select(dropdownElement);

	        // Select option by visible text
	        dropdown.selectByIndex(1); 
	        
	        
	    	driver.findElement(By.xpath("//div[@class='form-group col-md-6 mb-3 align']")).click();
			Thread.sleep(3000);
		
			
			//validation
			String act_mvalue=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-fd-calculator[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/span[1]")).getText();
			act_mvalue = act_mvalue.replaceAll("[^0-9.]", ""); // Keeps only numbers and decimal point
			// Ensure act_mvalue is not empty before parsing
			if (!act_mvalue.isEmpty()) {
			    double actualValue = Double.parseDouble(act_mvalue);
			    double expectedValue = Double.parseDouble(exp_mvalue);

			    if (expectedValue == actualValue) {
			        System.out.println("Test Passed");
			        Excelutls.setcelData(filePath, "Sheet1", i, 5, "Passed");
			        Excelutls.fillGreen(filePath, "Sheet1", i, 5);
			    } else {
			        System.out.println("Test Failed");
			        Excelutls.setcelData(filePath, "Sheet1", i, 5, "Failed");
			        Excelutls.fillRed(filePath, "Sheet1", i, 5);
			    }
			} else {
			    System.out.println("Test Failed - Empty Maturity Value");
			    Excelutls.setcelData(filePath, "Sheet1", i, 5, "Failed - Empty Value");
			    Excelutls.fillRed(filePath, "Sheet1", i, 5);
			}
		}
		
		
		 
        driver.navigate().refresh();

	     
			
	
	}

}

