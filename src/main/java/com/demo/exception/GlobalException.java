package com.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> employeeNotFoundException(EmployeeNotFoundException 
			employeeNotFoundException){
		ErrorResponse errorResponse = new ErrorResponse(404,
				employeeNotFoundException.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorResponse> invalidDataException(InvalidDataException 
			invalidDataException){
		ErrorResponse errorResponse = new ErrorResponse(400,
				invalidDataException.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
