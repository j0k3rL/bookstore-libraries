package com.bookstore.libraries.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class RollbackBusinessException extends BusinessException {

	private static final long serialVersionUID = -763480331338329276L;

	public RollbackBusinessException() {
		super();
	}
	
	public RollbackBusinessException(String message) {
		super(message);
	}
	
	public RollbackBusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RollbackBusinessException(Throwable cause) {
		super(cause);
	}
}