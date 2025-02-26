package demoone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//method 1:using sendkeys
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("01/01/2025");  //month,date,year
		
		//method 2:using date picker
		//expected data
		String year="2025";
		String month="May";
		String date="15";
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		//select month and year
		while(true) {
			String currentmonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equals(month) &&currentYear.equals(year)) {
				break;
			}
			
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					
		}
		
		//select the date
		List<WebElement> allDates= driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td/a"));
		
		for(WebElement dt:allDates) {
			if(dt.getText().equals(date)){
				dt.click();
			}
		}

	}

}
