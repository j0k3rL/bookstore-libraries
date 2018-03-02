package com.bookstore.libraries.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.validation.annotation.ProductCode;

public class ProductCodeValidator implements ConstraintValidator<ProductCode, String> {

	private Pattern pattern = Pattern.compile(BookstoreConstants.PRODUCT_CODE_PATTERN);
	
	public void initialize(ProductCode constraintAnnotation) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher m = pattern.matcher(value);
	    return m.matches();
	}
}