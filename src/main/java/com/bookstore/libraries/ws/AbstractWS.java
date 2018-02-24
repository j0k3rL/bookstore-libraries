package com.bookstore.libraries.ws;

import java.net.URL;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;

import com.bookstore.libraries.BookstoreConstants;
import com.bookstore.libraries.exception.ValidationException;
import com.bookstore.libraries.util.ResourceUtils;
import com.bookstore.libraries.validation.BeanValidator;
import com.bookstore.libraries.validation.SchemaValidator;

public abstract class AbstractWS implements BookstoreConstants {

	protected static Logger logger;

	@PostConstruct
	private void init() {
		logger = Logger.getLogger(this.getClass());
	}
	
	protected void validate(String schemaPath, Object... parameters) throws ValidationException {
	
		BeanValidator.validate(parameters);
		
		URL schema = ResourceUtils.getResource(this.getClass(), schemaPath);
		SchemaValidator.validate(schema, parameters);
	}
}