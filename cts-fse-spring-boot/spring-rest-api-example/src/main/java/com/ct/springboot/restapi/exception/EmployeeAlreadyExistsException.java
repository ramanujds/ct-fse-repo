package com.ct.springboot.restapi.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2710714629002036216L;

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
	
}
