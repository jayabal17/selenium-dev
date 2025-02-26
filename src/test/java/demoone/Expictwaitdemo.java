package demoone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Expictwaitdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));   //declaration
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement txUser= myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		txUser.sendKeys("Admin");
		
		WebElement pwdUser= myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		pwdUser.sendKeys("admin123");
		
		WebElement logibutton= myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		logibutton.click();
	
//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");


	}

}
