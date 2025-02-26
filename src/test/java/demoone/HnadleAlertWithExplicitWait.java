//package demoone;
//
//import java.time.Duration;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class HnadleAlertWithExplicitWait {
//
//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		
//		//Handle alert without usinh switch().alert()
//		//by using explict wait
//		
//		WebDriver driver=new ChromeDriver();
//		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));  //explictwait duration
//		
//	
//		
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		driver.manage().window().maximize();
//		
//		//1)normal alert ok button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//		Thread.sleep(3000);
//		
//		Alert myalert=mywait.until(ExpectedCondition.alertIsPresent());
//		System.out.println(myalert.getText());
//		myalert.accept();
//		
////		Alert myalert=driver.switchTo().alert();
////     	System.out.println(myalert.getText());
////		myalert.accept();
//
//	}
//
//}
