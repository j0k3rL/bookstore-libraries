package com.bookstore.libraries.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.validation.annotation.EmailValid;

public class EmailValidator implements ConstraintValidator<EmailValid, String> {

	private Pattern pattern = Pattern.compile(BookstoreConstants.CPF_PATTERN);
	
	public void initialize(EmailValid constraintAnnotation) {
		
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher m = pattern.matcher(value);
	    return m.matches();
	}
}