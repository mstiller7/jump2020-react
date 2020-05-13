package practice.dates;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	
	public static void main(String[] args) throws Exception {
		
		// how to convert a String to a Date?
		
		// when you create a new Date, it will be current
		Date date = new Date();
		System.out.println(date);
		
		// String to a Date: fix the problem
		String dateStr = "15/05/2017"; // d m y
		Date date4 = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
		System.out.println(date4);
		
	}

}
