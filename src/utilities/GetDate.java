package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
/**
 * Get current date need for test data
 * 
 * @author dabrowsm
 */

public class GetDate {
 
 public static String main(String[] args) {
 
	 // Create object of SimpleDateFormat class and decide the format
	 DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
 
	 //get current date time with Date()
	 Date date = new Date();
 
	 // Now format the date
	 String date1 = dateFormat.format(date);

     return date1;
  }

}