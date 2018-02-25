package com.bookstore.libraries.validation;

import javax.validation.ValidatorContext;

public interface ValidatorContextAwareConstraintValidator {

	void setValidatorContext(ValidatorContext validatorContext);
}