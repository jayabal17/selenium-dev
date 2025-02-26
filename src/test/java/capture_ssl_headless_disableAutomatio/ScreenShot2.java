package capture_ssl_headless_disableAutomatio;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://medicashift.heptotechnologies.org/");
        driver.manage().window().maximize();
        
        //1)Full page screenshot
        TakesScreenshot ts=(TakesScreenshot)driver;
        File sourcefile=ts.getScreenshotAs(OutputType.FILE);
        File targeFile=new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage4.png");
        sourcefile.renameTo(targeFile); //copy sourcefile to target file
        Thread.sleep(4000);
        
        //2)Capture the screenshot of specific section
        WebElement featureaProducts= driver.findElement(By.xpath("(//section[@class='feature-section bg-color-1 centred sec-pad'])[2]"));
        File sourcefile1=ts.getScreenshotAs(OutputType.FILE);
        featureaProducts.getScreenshotAs(OutputType.FILE);
        File targeFile1=new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage5.png");
        sourcefile1.renameTo(targeFile1); //copy sourcefile to target file
        
        
        
        
        //3)Capture the screenshot of webelement
        WebElement logo =driver.findElement(By.xpath("//div[@class='header-lower']//div[@class='logo-box']//a"));
        File sourcefile2=logo.getScreenshotAs(OutputType.FILE);
        featureaProducts.getScreenshotAs(OutputType.FILE);
        File targeFile2=new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage6.png");
        sourcefile2.renameTo(targeFile2); //copy sourcefile to target file
        
        driver.quit();

	}

}
