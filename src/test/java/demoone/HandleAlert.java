package demoone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
	
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
//		//1)normal alert ok button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//		Thread.sleep(3000);
//		
//		
//		Alert myalert=driver.switchTo().alert();
//		System.out.println(myalert.getText());
//		myalert.accept();
//		
//		Thread.sleep(3000);
//		//2 Confirmation alert -ok and cancel
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//		Thread.sleep(2000);
//		//driver.switchTo().alert().accept();  //close alert usinh ok
//		driver.switchTo().alert().dismiss(); //close the alert
		
		//handle alert with giving input field
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
	
		Alert myalert=driver.switchTo().alert();
		myalert.sendKeys("Welcome");
		Thread.sleep(2000);
		myalert.accept();
	}
	

}
