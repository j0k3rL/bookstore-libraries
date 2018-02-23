package com.bookstore.libraries.adapter;

import java.util.Calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.bookstore.libraries.util.DateTimeUtils;

public class DateTimeAdapter extends XmlAdapter<String, Calendar> {

	@Override
	public Calendar unmarshal(String date) throws Exception {
		return DateTimeUtils.parse(date);
	}

	@Override
	public String marshal(Calendar date) throws Exception {
		return DateTimeUtils.format(date.getTime());
	}
}