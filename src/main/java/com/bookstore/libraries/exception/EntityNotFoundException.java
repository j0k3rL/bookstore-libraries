package com.bookstore.libraries.exception;

public class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = -2998262506380030267L;

	public EntityNotFoundException() {
		super();
	}
	
	public EntityNotFoundException(String message) {
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}
}