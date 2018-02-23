package com.bookstore.libraries.exception;

public class SchemaValidationException extends Exception {

	private static final long serialVersionUID = 289493148142242025L;

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