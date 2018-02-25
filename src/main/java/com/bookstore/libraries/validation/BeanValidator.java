package com.bookstore.libraries.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.exception.ValidationException;
import com.bookstore.libraries.util.StringUtils;
import com.bookstore.libraries.ws.AbstractDTO;

public class BeanValidator {

	public synchronized static void validate(AbstractDTO... parameters) throws ValidationException {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		StringBuilder messageValidation = new StringBuilder();
		Set<ConstraintViolation<AbstractDTO>> constraintViolations = validator.validate(parameters[0]);

		while(constraintViolations.iterator().hasNext()) {
			messageValidation.append(constraintViolations.iterator().next().getMessage() + BookstoreConstants.NEW_LINE);
	    }
		
		if(StringUtils.isNotEmpty(messageValidation)) {
			throw new ValidationException(messageValidation.toString());
		}
	}
}