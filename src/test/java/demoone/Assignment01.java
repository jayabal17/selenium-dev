package demoone;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1)provide some string search for it
		//2) count number of link
		//3)click on each link using for loop
		//4)get windows id for every browser window
		//5)close speific browser window
		
		WebDriver driver=new ChromeDriver();
	
		

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//1)provide some string search for it
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/*
		 * //2) count number of link WebElement
		 * links=driver.findElement(By.tagName("a"));
		 * System.out.println("numner of links"+links.getSize());
		 */
		
		// 2) Count the number of links
		List<WebElement> links = driver.findElements(By.tagName("a")); // Use findElements for a list
		System.out.println("Number of links on the page: " + links.size());
		
		//3)click on each link using for loop

}
}
