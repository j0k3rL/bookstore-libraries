package com.bookstore.libraries.exception;

import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class RequestErrorHandler implements ErrorHandler {

	private static Logger logger = Logger.getLogger(RequestErrorHandler.class);
	
	public void warning(SAXParseException exception) throws SAXException {
		logger.debug("\\nWARNING", exception);
	}

	public void error(SAXParseException exception) throws SAXException {
		logger.error("\\nERROR", exception);
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		logger.fatal("\\FATAL", exception);
	}
}