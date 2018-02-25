package com.bookstore.libraries.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bookstore.libraries.validation.CollectionValidator;

@Constraint(validatedBy = CollectionValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CollectionValid {

	Class<?> elementType();
    Class<?>[] constraints() default {};
    boolean allViolationMessages() default true;
    
    String message() default "{ValidCollection.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}