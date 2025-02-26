package keyboardaction;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpentheLinkInNewTabUsingKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.cabocab.co.in/");
		driver.manage().window().maximize();
		
		
		WebElement regLink=driver.findElement(By.xpath("//a[normalize-space()='Support']"));
		Actions act=new Actions(driver);
		
		//control
		act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
		
		//switching to register page
		List<String> ids=new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(ids.get(1));
		WebElement element = driver.findElement(By.xpath("//input[@id='firstName']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement send=driver.findElement(By.xpath("//input[@id='firstName']"));
		send.sendKeys("jba");

		
		//switch to browser 1
		driver.switchTo().window(ids.get(0));

	}

}

