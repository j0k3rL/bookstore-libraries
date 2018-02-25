package com.bookstore.libraries.validation;

import java.beans.Introspector;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorContext;
import javax.validation.metadata.BeanDescriptor;
import javax.validation.metadata.ConstraintDescriptor;
import javax.validation.metadata.PropertyDescriptor;

import com.bookstore.libraries.validation.annotation.CollectionValid;

@SuppressWarnings("rawtypes")
public class CollectionValidator implements ConstraintValidator<CollectionValid, Collection>, ValidatorContextAwareConstraintValidator {

	private ValidatorContext validatorContext;

	private Class<?> elementType;
	private Class<?>[] constraints;
	private boolean allViolationMessages;

	public void setValidatorContext(ValidatorContext validatorContext) {
		this.validatorContext = validatorContext;
	}

	public void initialize(CollectionValid constraintAnnotation) {
		elementType = constraintAnnotation.elementType();
		constraints = constraintAnnotation.constraints();
		allViolationMessages = constraintAnnotation.allViolationMessages();
	}

	public boolean isValid(Collection collection, ConstraintValidatorContext context) {

		boolean valid = true;

		if (collection == null) {
			return false;
		}

		Validator validator = validatorContext.getValidator();
		boolean beanConstrained = validator.getConstraintsForClass(elementType).isBeanConstrained();

		for (Object element : collection) {

			Set<ConstraintViolation<?>> violations = new HashSet<ConstraintViolation<?>>();

			if (beanConstrained) {

				boolean hasValidCollectionConstraint = hasValidCollectionConstraint(elementType);

				if (hasValidCollectionConstraint) {
					violations.addAll(validator.validate(element));
				} else {
					violations.addAll(validator.validate(element));
				}

			} else {

				for (Class<?> constraint : constraints) {
					String propertyName = constraint.getSimpleName();
					propertyName = Introspector.decapitalize(propertyName);
					violations.addAll(validator.validateValue(CollectionElementBean.class, propertyName, element));
				}
			}

			if (!violations.isEmpty()) {
				valid = false;
			}

			if (allViolationMessages) {

				for (ConstraintViolation<?> violation : violations) {

					ConstraintViolationBuilder violationBuilder = context
							.buildConstraintViolationWithTemplate(violation.getMessage());
					violationBuilder.addConstraintViolation();
				}
			}

		}

		return valid;
	}

	private boolean hasValidCollectionConstraint(Class<?> beanType) {

		BeanDescriptor beanDescriptor = validatorContext.getValidator().getConstraintsForClass(beanType);
		boolean isBeanConstrained = beanDescriptor.isBeanConstrained();

		if (!isBeanConstrained) {
			return false;
		}

		Set<ConstraintDescriptor<?>> constraintDescriptors = beanDescriptor.getConstraintDescriptors();

		for (ConstraintDescriptor<?> constraintDescriptor : constraintDescriptors) {

			if (constraintDescriptor.getAnnotation().annotationType().getName()
					.equals(CollectionValid.class.getName())) {
				return true;
			}
		}

		Set<PropertyDescriptor> propertyDescriptors = beanDescriptor.getConstrainedProperties();

		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {

			constraintDescriptors = propertyDescriptor.getConstraintDescriptors();

			for (ConstraintDescriptor<?> constraintDescriptor : constraintDescriptors) {

				if (constraintDescriptor.getAnnotation().annotationType().getName()
						.equals(CollectionValid.class.getName())) {
					return true;
				}
			}
		}

		return false;
	}
}