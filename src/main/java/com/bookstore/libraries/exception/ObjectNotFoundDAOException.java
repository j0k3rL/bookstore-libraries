package com.bookstore.libraries.exception;

public class ObjectNotFoundDAOException extends DAOException {

	private static final long serialVersionUID = -2492066958394327345L;

	public ObjectNotFoundDAOException() {
		super();
	}
	
	public ObjectNotFoundDAOException(String message) {
		super(message);
	}
	
	public ObjectNotFoundDAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ObjectNotFoundDAOException(Throwable cause) {
		super(cause);
	}
}