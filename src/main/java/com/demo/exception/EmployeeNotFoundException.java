package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * used to throw the custom exception when an employee is not found in the DB.
	 *
	 * @author Sumit Singh Dosad Sumit Sumit
	 */
	public EmployeeNotFoundException(String message) {
		super(message);
		System.out.println("EmployeeNotFoundException: " + message);
	}
}
