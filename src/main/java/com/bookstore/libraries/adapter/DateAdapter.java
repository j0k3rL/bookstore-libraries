package com.bookstore.libraries.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.util.DateUtils;

public class DateAdapter extends XmlAdapter<String, Calendar> implements BookstoreConstants {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
	
	@Override
	public Calendar unmarshal(String date) throws Exception {
		synchronized (dateFormat) {
			return DateUtils.convertToCalendar(dateFormat.parse(date));
		}
	}

	@Override
	public String marshal(Calendar date) throws Exception {
		synchronized (dateFormat) {
			return dateFormat.format(date.getTime());
		}
	}
}