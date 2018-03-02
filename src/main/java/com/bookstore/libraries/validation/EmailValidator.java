package com.bookstore.libraries.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.validation.annotation.Email;

public class EmailValidator implements ConstraintValidator<Email, String> {

	private Pattern pattern = Pattern.compile(BookstoreConstants.EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
	
	public void initialize(Email constraintAnnotation) {
		
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher m = pattern.matcher(value);
	    return m.matches();
	}
}