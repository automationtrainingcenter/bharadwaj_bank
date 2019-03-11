package utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
