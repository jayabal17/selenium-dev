package day2;


import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class CabocabCorporateBookingAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 ChromeOptions options = new ChromeOptions();
			
	        
		 Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.default_content_setting_values.notifications", 1); // 1 = Allow, 2 = Block
	        options.setExperimentalOption("prefs", prefs);
	    
	    
		ChromeDriver driver=new ChromeDriver(options);
	    driver.get("https://cabocab.corporate.heptotechnologies.org/");
	    driver.navigate().refresh();
	    

	
		
		  WebElement inputField = driver.findElement(By.id("userEmail"));                 	//entering data
		  inputField.sendKeys("nagaraj@heptotechnologies.org");
		  WebElement inputFieldPassword = driver.findElement(By.id("userPassword"));
		  inputFieldPassword.sendKeys("Password@123");
		  driver.manage().window().maximize();
		
		  Thread.sleep(12000);
		  
	      WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	      button.click();
          Thread.sleep(7000);
         
          
          
         WebElement button1 = driver.findElement(By.xpath("//span[normalize-space()='Manual Booking']"));    //Manual booking 
	     button1.click();
	     Thread.sleep(3000);
	        
	      WebElement button2 = driver.findElement(By.xpath("//label[normalize-space()='Local']"));
		  button2.click();
		  
		  
		  
		  Thread.sleep(3000);
		  WebElement startLocation = driver.findElement(By.id("pickup-location"));     //Location for start point
	      startLocation.sendKeys("Pavoo");
	      
	      Actions actions=new Actions(driver);
	      actions.pause(java.time.Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	      
	      WebElement endLocation = driver.findElement(By.id("drop-location"));     //Location for endpoint
	      endLocation.sendKeys("t");
	      endLocation.sendKeys("e");
	      endLocation.sendKeys("n");
	      endLocation.sendKeys("k");
	      actions.pause(java.time.Duration.ofSeconds(2)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	      Thread.sleep(3000);
	      
	     
	        JavascriptExecutor js = (JavascriptExecutor) driver;                              // Create a JavascriptExecutor instance   for scroll
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        Thread.sleep(3000);
	        
	        
	        WebElement button3 = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/div[4]/div[1]/button[2]"));
	        button3.click();
	        Thread.sleep(2000);
	        js.executeScript("window.scrollTo(0, 0)");
	        
		  WebElement button4 = driver.findElement(By.xpath(" /html[1]/body[1]/div[2]/main[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[4]/label[1]"));    //Manual booking 
		  button4.click();
		  Thread.sleep(2000);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  
		  
		  WebElement ridername = driver.findElement(By.id("ridername"));     //user details
		  ridername.sendKeys("Jba");
		  WebElement ridernumber = driver.findElement(By.id("riderphone"));    
		  ridernumber.sendKeys("8124377712");
		  
		  WebElement findingDriver = driver.findElement(By.id("availabledriver_btn"));    
		  findingDriver.click();
	      
	}
	

}
