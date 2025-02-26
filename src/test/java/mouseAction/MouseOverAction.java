package mouseAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.heptotechnologies.com/");
		driver.manage().window().maximize();
		
		//alert hide
        driver.findElement(By.xpath("//span[@aria-hidden='true']")).click();
        
        Thread.sleep(2000);
        
        WebElement insight=driver.findElement(By.xpath("//a[normalize-space()='Insights']"));
        WebElement blog= driver.findElement(By.xpath("//a[normalize-space()='Blog']"));
		
		Actions act=new Actions(driver);
		
		//mouse over action
		act.moveToElement(insight).moveToElement(blog).click() .build().perform();

	}

}
