package com.bookstore.libraries.validation;

import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.bookstore.libraries.exception.SchemaValidationException;

public class SchemaValidator {

	public synchronized static void validate(URL schemaResource, Object... parameters) throws SchemaValidationException {

		try {

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(schemaResource);
			
			Validator validator = schema.newValidator();

			for (Object param : parameters) {
				
				JAXBContext jc = JAXBContext.newInstance(param.getClass());
				validator.validate(new JAXBSource(jc, param));
			}
			
		} catch (Exception e) {
			throw new SchemaValidationException(e);
		}
	}
}