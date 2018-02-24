package com.bookstore.libraries.exception;

import javax.xml.ws.WebFault;

@WebFault(name="WebServiceFault")
public class WebServiceException extends Exception {

	private static final long serialVersionUID = 1766951365021029712L;

	public WebServiceException() {
		super();
	}
	
	public WebServiceException(String message) {
		super(message);
	}
	
	public WebServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public WebServiceException(Throwable cause) {
		super(cause);
	}
	
	public String getFaultInfo() {
		return getMessage();
	}
}