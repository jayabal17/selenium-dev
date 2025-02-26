package calculatorDataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dataDriven_testing.Excelutls;

public class FdCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.sbisecurities.in/calculators/fd-calculator");
		
		String filePath=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int rows= Excelutls.getRowcount(filePath, "Sheet1");
		
		for(int i=1;i<=rows;i++)
		{
			//1)read data from excel
			String pric=  Excelutls.getcellData(filePath, "Sheet1", i, 0);
			String rateofinterest=  Excelutls.getcellData(filePath, "Sheet1", i, 1);
			String per1=  Excelutls.getcellData(filePath, "Sheet1", i, 2);
			String per2=  Excelutls.getcellData(filePath, "Sheet1", i, 3);
			//String fre=  Excelutls.getcellData(filePath, "Sheet1", i, 4);
			String exp_mvalue= Excelutls.getcellData(filePath, "Sheet1", i,5 );
			
			//2)Pass above data into the application
			driver.findElement(By.xpath("//div[@class='input-group']//input[@id='input_fd_investment']")).sendKeys(pric);
			driver.findElement(By.xpath("//input[@id='input_interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//body/app-root/app-fd-calculator[@class='ng-star-inserted']/div[@class='container']/div[@class='col-md-12 pt-5 mt-5']/div[@class='row pdt-30']/div[@class='col-xl-9 col-lg-7 col-md-7']/div[@class='border']/form[@id='validForm']"
					              + "/div[@class='row mt-2 d-flex']/div[@class='form-group col-md-6 mb-3']/input[1]")).sendKeys(per1);
			
			
			Select perdrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			perdrp.selectByVisibleText(per2);
			
			driver.findElement(By.xpath("//div[@class='form-group col-md-6 mb-3 align']")).click();
			Thread.sleep(3000);
			
			
			//validation
			String act_mvalue=driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-fd-calculator[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/span[1]")).getText();
			if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue))
			{
				System.out.println("Test passed");
				Excelutls.setcelData(filePath, "Sheet1",i,7,"Passed");
				Excelutls.fillGreen(filePath, "Sheet1", i, 7);
			}else {
				System.out.println("Test Failed");
				Excelutls.setcelData(filePath, "Sheet1",i,7,"Failed");
				Excelutls.fillRed(filePath, "Sheet1", i, 7);
			}
		}
		 
        driver.navigate().refresh();
		
		

	}

}
