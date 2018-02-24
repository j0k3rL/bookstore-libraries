package com.bookstore.libraries.exception;

public class SchemaValidationException extends ValidationException {

	private static final long serialVersionUID = -8731110545711569848L;

	public SchemaValidationException() {
		super();
	}
	
	public SchemaValidationException(String message) {
		super(message);
	}
	
	public SchemaValidationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public SchemaValidationException(Throwable cause) {
		super(cause);
	}
}