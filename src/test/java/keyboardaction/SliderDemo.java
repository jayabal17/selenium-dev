package keyboardaction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//Min slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		System.out.println("Default Location of the main slider"+min_slider.getLocation()); // (59, 294)
		act.dragAndDropBy(min_slider, 100,249).perform();
		System.out.println("Location of the min slider after moving"+min_slider.getLocation());  // 161 294
		
		//Max slide
		WebElement max_slider=driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		System.out.println("Default Location of the max slider"+max_slider.getLocation()); // (544, 294)
		act.dragAndDropBy(max_slider, -100 , 249).perform();
		System.out.println("Location of the max slider after moving"+max_slider.getLocation());  // 161 200

	}

}
