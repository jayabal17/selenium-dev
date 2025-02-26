package capture_ssl_headless_disableAutomatio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedmessageonscreen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver=new ChromeDriver(options); //for chrome driver
		
		//WebDriver driver=new edgedriver();
		//WebDriver driver=new firefoxdriver();
		//shromiumdriver driver=new chromedriver();

		//2)Open url
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		//3)title should be your store
		String act_title=driver.getTitle();
		
		if(act_title.equals("OpenCart - Demo")) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
		
		

	}

}
