package com.demo.exception;


import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.constant.ApplicationConstant;
import com.demo.controller.EmployeeController;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{	
	
	private static final Logger log = Logger.getLogger(EmployeeController.class.getName());
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> employeeNotFoundException(EmployeeNotFoundException 
			employeeNotFoundException){
		log.error(ApplicationConstant.employeeException);
		
		ErrorResponse errorResponse = new ErrorResponse(404,
				employeeNotFoundException.getMessage());
		
		log.debug(ApplicationConstant.handled);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorResponse> invalidDataException(InvalidDataException 
			invalidDataException){
		log.error(ApplicationConstant.dataException);
		
		ErrorResponse errorResponse = new ErrorResponse(400,
				invalidDataException.getMessage());
		
		log.debug(ApplicationConstant.handled);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
