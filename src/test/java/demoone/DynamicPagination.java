package demoone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicPagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		WebElement usernmae= driver.findElement(By.id("input-username"));
		usernmae.clear();
		usernmae.sendKeys("demo");
		
		WebElement password= driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("demo");
		
		
	
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[6]/a[1]")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();

		Thread.sleep(5000);
		
		String text= driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
		int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1)); 
		
		//repeating pages
		for(int p=1;p<total_pages;p++) {
			if(p>1) {
			WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
			active_page.click();
			Thread.sleep(4000);
			}
			
			//reading data from the page
			int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			for(int r=1;r<noOfRows;r++)
			{
				String customer= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover]//tbody//tr["+r+"]/td[2]")).getText();
				String email=  driver.findElement(By.xpath("//table[@class='table table-bordered table-hover]//tbody//tr["+r+"]/td[3]")).getText();
				String status=  driver.findElement(By.xpath("//table[@class='table table-bordered table-hover]//tbody//tr["+r+"]/td[5]")).getText();
				System.out.println(customer+"\t"+email+"\t"+status);
			}
			
		}
	}

}
