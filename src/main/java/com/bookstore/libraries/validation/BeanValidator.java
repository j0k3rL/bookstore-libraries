package com.bookstore.libraries.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.exception.ValidationException;
import com.bookstore.libraries.util.CollectionUtils;
import com.bookstore.libraries.util.StringUtils;

public class BeanValidator {

	private BeanValidator() {}
	
	public static void validate(Object... parameters) throws ValidationException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		StringBuilder messageValidation = new StringBuilder();
		
		for(Object param : parameters) {
		
			Set<ConstraintViolation<Object>> constraintViolations = validator.validate(param);
			
			for(ConstraintViolation<Object> cv : constraintViolations) {
				messageValidation.append(cv.getMessage() + BookstoreConstants.NEW_LINE);
			}
		}
		
		if(StringUtils.isNotEmpty(messageValidation)) {
			throw new ValidationException(messageValidation.toString());
		}
	}
	
	public static void validateProperty(Object parameter, String property) throws ValidationException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<Object>> constraintViolation = validator.validateProperty(parameter, property);
		
		if(CollectionUtils.isNotEmpty(constraintViolation)) {
			throw new ValidationException(constraintViolation.iterator().next().getMessage());
		}
	}
}