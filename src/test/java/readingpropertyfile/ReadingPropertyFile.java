package readingpropertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//location of properties file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		//String filePath=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		
	
		
		//loading properties file
		Properties propertiesobj=new Properties();
		propertiesobj.load(file);
		
		
		//reading data from properties file
		 String url= propertiesobj.getProperty("appurl");
		 String email= propertiesobj.getProperty("email");
		 String pwd= propertiesobj.getProperty("password");
		 String orderidd= propertiesobj.getProperty("orderid");
		 String cusid= propertiesobj.getProperty("customerid");
		 
		 
		 System.out.println(url +" "+email+" "+pwd+" "+orderidd+" "+cusid );   
		 
		//Reading all the keys from properties file
		 //model 1
		Set<String> keysSet=propertiesobj.stringPropertyNames();
		System.out.println(keysSet);

		//model 2
		Set<Object> keys=propertiesobj.keySet();
		System.out.println(keys);
		
		//readingg value
		Collection<Object> values=propertiesobj.values();
		System.out.println(values);
		
		file.close();
	}

}

