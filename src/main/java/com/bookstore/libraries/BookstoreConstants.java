package com.bookstore.libraries;

public interface BookstoreConstants {

	public static final String CPF_PATTERN = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)";
	public static final String EMAIL_PATTERN = "/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/";
	public static final String PRODUCT_CODE_PATTERN = "\\d{4}-\\d{4}";
	public static final String UNIT_CODE_PATTERN = "\\d{4}-\\d{4}";
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static final String CPF_VALIDATION_MESSAGE = "Invalid CPF.";
	public static final String EMAIL_VALIDATION_MESSAGE = "Invalid E-mail.";
	public static final String PRODUCT_CODE_VALIDATION_MESSAGE = "Invalid Product Code.";
	public static final String UNIT_CODE_VALIDATION_MESSAGE = "Invalid Unit Code.";
	
	public static final String NEW_LINE = "\n";
	public static final String EMPTY = "";
}