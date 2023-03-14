package com.springtuts.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	// read a date string and parse/convert to a date
	public static Date parseDate(String dateString) throws ParseException {
		Date theDate = formatter.parse(dateString);
		return theDate;
	}
	
	// read a date and format/convert to a string
	public static String formatDate(Date theDate) {
		String result = null;
		
		if(null != theDate) {
			result = formatter.format(theDate);
		}
		return result;
	}
}
