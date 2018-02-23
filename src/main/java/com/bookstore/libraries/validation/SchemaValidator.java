package com.bookstore.libraries.validation;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.bookstore.libraries.exception.SchemaValidationException;

public class SchemaValidator {

	@SuppressWarnings("rawtypes")
	public synchronized static void validate(String schemaPath, Class clazz, Object... request)
			throws SchemaValidationException {

		try {

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(clazz.getClassLoader().getResource(schemaPath));

			JAXBContext jc = JAXBContext.newInstance(clazz);
			Validator validator = schema.newValidator();

			for (Object value : request) {
				validator.validate(new JAXBSource(jc, value));
			}
		} catch (Exception e) {
			throw new SchemaValidationException(e);
		}
	}
}