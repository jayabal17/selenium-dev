package capture_ssl_headless_disableAutomatio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        
        // Ensure the Screenshots directory exists
        File targetDir = new File(System.getProperty("user.dir") + "\\Screenshots");
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }
        
        // Full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourcefile = ts.getScreenshotAs(OutputType.FILE);
        File targetfile = new File(targetDir, "fullpage1.png");
        
        try {
            // Overwrite the file if it already exists
            Files.copy(sourcefile.toPath(), targetfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved to: " + targetfile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit(); // Close the browser
    }
}
