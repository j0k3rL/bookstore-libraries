package com.bookstore.libraries.util;

public class StringUtils {

	public static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}
	
	public static boolean isEmpty(StringBuilder sb) {
		return sb == null || sb.toString().isEmpty();
	}
	
	public static boolean isNotEmpty(String str) {
		return !StringUtils.isEmpty(str);
	}
	
	public static boolean isNotEmpty(StringBuilder sb) {
		return !StringUtils.isEmpty(sb);
	}
}