package com.bookstore.libraries.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bookstore.libraries.validation.CpfValidator;

@Constraint(validatedBy = CpfValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfValid {

	String message() default "Invalid CPF";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}