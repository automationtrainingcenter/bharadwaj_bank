package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class GenericHelper {
	/**
	 * returns date and time of the current machine 
	 * @return
	 */
	public String getDateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd_MMM_yy-HH_mm_ss");
		return df.format(date);
	}
	
	
	public String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir")+File.separator+folderName+File.separator+fileName;
	}
	
	public void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String readProperty(String propertyName) {
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(getFilePath(".\\", "config.properties"));
			Properties prop = new Properties();
			prop.load(fis);
			value =  prop.getProperty(propertyName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return value;
		
	}
}
