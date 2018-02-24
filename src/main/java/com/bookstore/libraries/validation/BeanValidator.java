package com.bookstore.libraries.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.exception.ValidationException;
import com.bookstore.libraries.util.StringUtils;

public class BeanValidator {

	public synchronized static void validate(Object... parameters) throws ValidationException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		StringBuilder messageBuilder = new StringBuilder();
		Set<ConstraintViolation<Object[]>> constraintViolations = validator.validate(parameters);

		while(constraintViolations.iterator().hasNext()) {
			messageBuilder.append(constraintViolations.iterator().next().getMessage() + BookstoreConstants.NEW_LINE);
	    }
		
		if(StringUtils.isNotEmpty(messageBuilder)) {
			throw new ValidationException(messageBuilder.toString());
		}
	}
}