package com.bookstore.libraries.exception;

public class NonUniqueResultDAOException extends DAOException {

	private static final long serialVersionUID = 5546491639513228232L;

	public NonUniqueResultDAOException() {
		super();
	}
	
	public NonUniqueResultDAOException(String message) {
		super(message);
	}
	
	public NonUniqueResultDAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NonUniqueResultDAOException(Throwable cause) {
		super(cause);
	}
}