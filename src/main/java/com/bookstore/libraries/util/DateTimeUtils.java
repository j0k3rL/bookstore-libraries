package com.bookstore.libraries.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.bookstore.libraries.BookstoreConstants;

public class DateTimeUtils {

	public static Calendar convertToCalendar(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	public static Calendar parse(String date) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(BookstoreConstants.DATE_PATTERN);
		return convertToCalendar(dateFormat.parse(date));
	}
	
	public static Calendar parse(String date, String pattern) throws ParseException, IllegalArgumentException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return convertToCalendar(dateFormat.parse(date));
	}
	
	public static String format(Date date) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(BookstoreConstants.DATE_PATTERN);
		return dateFormat.format(date);
	}
}