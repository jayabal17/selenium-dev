package linkTesting;


import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	//  link href="https://xyz.com
	//server status code
	//check 400 or not
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links"+links.size());
		
		int noofBrokenLinks=0;
		
		for(WebElement linkElement:links) {
			@SuppressWarnings("deprecation")
			String hrefattValue=linkElement.getAttribute("href");
			if(hrefattValue==null || hrefattValue.isEmpty()) {
				System.out.println("href attribute value is null or empty.so not possible to check");
				continue;
			}
			//hit url to the server
			try {
				
				@SuppressWarnings("deprecation")
				URL linkURL=new URL(hrefattValue);   //CONVERTED href to value from string to url format
				HttpURLConnection conn= (HttpURLConnection)linkURL.openConnection();
				conn.connect();
				
				if(conn.getResponseCode()>=400) {
					System.out.println("Broken link");
				}
				else {
					System.out.println("Not a broken link ====>"+links.size());
					noofBrokenLinks++;
				
			}
			}
				catch(Exception e) {
					}
				}
		System.out.println("Number of broken links"+noofBrokenLinks);
	}
}
		
			
			
		
			
		
		
		
	


