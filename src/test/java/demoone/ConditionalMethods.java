package demoone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//isdisplayed();
		
//		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//		System.out.println("Display status of logo :"+logo.isDisplayed());

		
		boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Display status:"+status);
		
		
		//isenabled();
		boolean status1=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Enable status:"+status1);
		
		
		//is seleected();
		WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selection....");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		System.out.println("After selection....");
		male_rd.click();
		
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		boolean newsletterStatus= driver.findElement(By.id("Newsletter")).isSelected();
		System.out.println("NEWS letter checkbox status"+newsletterStatus);
		
		
	}
	
	

}

