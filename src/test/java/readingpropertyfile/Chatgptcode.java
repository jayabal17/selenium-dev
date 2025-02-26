 //Chatgptcode

package readingpropertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Chatgptcode {

    public static void main(String[] args) throws IOException {
        // Create an object of Properties class
        Properties propertiesObj = new Properties();

        // Location of properties file
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testdata\\config.properties");

        // Loading properties file
        propertiesObj.load(file);

        // Reading data from properties file
        String url = propertiesObj.getProperty("appurl");
        String email = propertiesObj.getProperty("email");
        String pwd = propertiesObj.getProperty("password");
        String orderid = propertiesObj.getProperty("orderid");
        String cusid = propertiesObj.getProperty("customerid");

        // Print values
        System.out.println("URL: " + url);
        System.out.println("Email: " + email);
        System.out.println("Password: " + pwd);
        System.out.println("Order ID: " + orderid);
        System.out.println("Customer ID: " + cusid);

        // Close the file input stream
        file.close();
    }
}

