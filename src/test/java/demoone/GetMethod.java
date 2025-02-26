package demoone;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethod {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		//get url-opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		//Get title() -return title of the page
		System.out.println(driver.getTitle());
		
		//getcurrenturl()-return the url o thepage
		 System.out.println(driver.getCurrentUrl()); 
		 
		//getpagesource()-returns source code of the page
		// System.out.println(driver.getPageSource());
		 
		 //get windowhandle()-return id of the single browser window
		 String windowid=driver.getWindowHandle();
		 System.out.println("windowid"+windowid);
		 
		 //getwindowhandles()-returns ids of the multiple browser window
		 driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		  Set<String> WINDOWS=driver.getWindowHandles();
		  System.out.println(WINDOWS);
		 

	}

}
