package com.bookstore.libraries.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.validation.EmailValidator;

@Constraint(validatedBy = EmailValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValid {

	String message() default BookstoreConstants.EMAIL_VALIDATION_MESSAGE;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}