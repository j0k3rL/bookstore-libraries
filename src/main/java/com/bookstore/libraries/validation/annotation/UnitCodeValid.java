package com.bookstore.libraries.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bookstore.libraries.validation.ProductCodeValidator;

@Constraint(validatedBy = ProductCodeValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitCodeValid {

	String message() default "Invalid Unit Code";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}