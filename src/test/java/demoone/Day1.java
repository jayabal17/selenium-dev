package demoone;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ChromeOptions options = new ChromeOptions();
		  // Enable headless mode
	        options.addArguments("--headless");
		System.out.println("testing");
		//1)Launch browser 
		ChromeDriver driver=new ChromeDriver(options);
		  // Enable headless mode
        options.addArguments("--headless");
		//2)open url:
		driver.get("https://www.heptotechnologies.com/");
		//3)Validate the title:
		String act_title=driver.getTitle();
			if(act_title.equals("Mobile App Development Company USA | Services USA | Hepto"))
			{
				System.out.println("Test Passed");
			}else
				System.out.println("Test Failed");
			
		//4)Close browser
			//driver.close();

	}

}
