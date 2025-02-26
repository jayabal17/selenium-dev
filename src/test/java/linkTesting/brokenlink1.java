package linkTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlink1 {

    public static void main(String[] args) {
        // Set up the ChromeDriver (adjust the path if necessary)
        WebDriver driver=new ChromeDriver();
     

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://medicashift.heptotechnologies.org/");
            driver.manage().window().maximize();

            // Find all anchor tags
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Total number of links: " + links.size());

            int noOfBrokenLinks = 0;

            // Loop through each link and check the response code
            for (WebElement linkElement : links) {
                String hrefValue = linkElement.getAttribute("href");
                System.out.println("Checking link: " + hrefValue);

                if (hrefValue == null || hrefValue.isEmpty()) {
                    System.out.println("Skipping link with null or empty href attribute.");
                    continue;
                }

                try {
                    URL linkURL = new URL(hrefValue); // Convert href string to URL
                    HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
                    conn.setRequestMethod("HEAD"); // Use HEAD for a lightweight request
                    conn.connect();

                    int responseCode = conn.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println("Broken link: " + hrefValue + " | Response code: " + responseCode);
                        noOfBrokenLinks++;
                    } else {
                        System.out.println("Valid link: " + hrefValue + " | Response code: " + responseCode);
                    }
                } catch (Exception e) {
                    System.out.println("Error checking link: " + hrefValue);
                    e.printStackTrace();
                }
            }

            System.out.println("Number of broken links: " + noOfBrokenLinks);

        } finally {
            // Quit the browser
            driver.quit();
        }
    }
}
