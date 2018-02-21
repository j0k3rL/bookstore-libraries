package com.bookstore.libraries.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static final Calendar convertToCalendar(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}