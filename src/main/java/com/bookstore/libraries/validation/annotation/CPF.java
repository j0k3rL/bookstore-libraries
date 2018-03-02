package com.bookstore.libraries.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.validation.CpfValidator;

@Deprecated
@Constraint(validatedBy = CpfValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CPF {

	String message() default BookstoreConstants.CPF_VALIDATION_MESSAGE;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}