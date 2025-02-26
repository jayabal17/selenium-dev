//package demoone;
//
//
//
//import java.time.Duration;
//import java.util.NoSuchElementException;
//import java.util.function.Function;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//
//public class FluentWaitDemo {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WebDriver driver=new ChromeDriver();
//		//fluent with declaration
//		Wait<WebDriver> myywait=new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(5))
//				.ignoring(NoSuchElementException.class);
//		
//		
//		
//		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.id("//input[@placeholder='Username']")).sendKeys("Admin");
//	
//		
//		WebElement txtUsername=myywait.until(new Function<WebDriver , WebElement> (){
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath("//button[@type='submit']"));
//			}
//		}
//				);
//
//	}
//
//}
