package day2;


import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CabocabAdmin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		 ChromeOptions options = new ChromeOptions();
//		  // Enable headless mode
//	        options.addArguments("--headless");
			
	        
		 Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.default_content_setting_values.notifications", 1); // 1 = Allow, 2 = Block
	        options.setExperimentalOption("prefs", prefs);
	    
	    
		ChromeDriver driver=new ChromeDriver(options);
	    driver.get("https://cabocab.admin.heptotechnologies.org/");
	    driver.navigate().refresh();
		
		
    
		//entering data
		
		  WebElement inputField = driver.findElement(By.id("adminEmail"));
		  inputField.sendKeys("pommym9@gmail.com");
		  
		 
		 WebElement inputFieldPassword = driver.findElement(By.id("adminpassword"));
		  inputFieldPassword.sendKeys("12345678");
		  
		  driver.manage().window().maximize();
		
		 
		  Thread.sleep(12000);
		  
         WebElement button = driver.findElement(By.id("login_button"));
         button.click();
 
	    
	     
		}
}
