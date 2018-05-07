package com.bookstore.libraries.exception;

public class ReportException extends Exception {

	private static final long serialVersionUID = -3881677934114011036L;

	public ReportException() {
		super();
	}

	public ReportException(String message) {
		super(message);
	}

	public ReportException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReportException(Throwable cause) {
		super(cause);
	}
}