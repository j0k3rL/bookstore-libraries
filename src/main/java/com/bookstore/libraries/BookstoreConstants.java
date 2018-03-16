package com.bookstore.libraries;

public interface BookstoreConstants {

	public static final String CPF_PATTERN = "^(?!00000000000|11111111111|22222222222|33333333333|44444444444|55555555555|66666666666|77777777777|88888888888|99999999999*$)\\d{11}$";
	public static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
	public static final String PRODUCT_CODE_PATTERN = "\\d{4}-\\d{4}";
	public static final String UNIT_CODE_PATTERN = "\\d{4}-\\d{4}";
	public static final String ONLY_NUMBERS_PATTERN = "[^\\d.]";
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static final String PRODUCT_CODE_VALIDATION_MESSAGE = "Invalid Product Code.";
	public static final String UNIT_CODE_VALIDATION_MESSAGE = "Invalid Unit Code.";
	
	public static final String NEW_LINE = "\n";
	public static final String EMPTY = "";
	public static final String DEPENDENCY_INJECTION = "cdi";
}