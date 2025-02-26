package demoone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		 WebElement frame1= driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		 driver.switchTo().frame(frame1);  
		 //passed frame as a webelement
		 driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
		 driver.switchTo().defaultContent();
		 
		 //frame 2
		WebElement frame2=  driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		 driver.switchTo().frame(frame2);
		 driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("selenium");
		 Thread.sleep(2000);
		 
//		 
//		 //frame 3
//		 WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
//		 driver.switchTo().frame(frame3);
//		 driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("java");
		 
		 
		 
	}

}
