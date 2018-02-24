package com.bookstore.libraries.util;

import com.bookstore.libraries.BookstoreConstants;

public class StringUtils {

	public static boolean isEmpty(String str) {
		return str == null || str.equals(BookstoreConstants.EMPTY);
	}
	
	public static boolean isEmpty(StringBuilder sb) {
		return sb == null || sb.toString().equals(BookstoreConstants.EMPTY);
	}
	
	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}
	
	public static boolean isNotEmpty(StringBuilder sb) {
		return !StringUtils.isEmpty(sb);
	}
}