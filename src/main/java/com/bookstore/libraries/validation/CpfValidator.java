package com.bookstore.libraries.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.validation.annotation.CpfValid;

public class CpfValidator implements ConstraintValidator<CpfValid, String> {

	private Pattern pattern = Pattern.compile(BookstoreConstants.CPF_PATTERN);
	
	public void initialize(CpfValid constraintAnnotation) {}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher m = pattern.matcher(value);
	    return m.matches();
	}
}