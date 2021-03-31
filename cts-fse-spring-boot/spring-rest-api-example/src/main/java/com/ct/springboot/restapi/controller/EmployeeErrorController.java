package com.ct.springboot.restapi.controller;

import java.util.Date;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ct.springboot.restapi.dto.ErrorResponseDto;
import com.ct.springboot.restapi.exception.EmployeeAlreadyExistsException;
import com.ct.springboot.restapi.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class EmployeeErrorController {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({EmployeeNotFoundException.class,EntityNotFoundException.class})
	public ErrorResponseDto handleEmployeeNotFoundError(Exception ex, HttpServletRequest request) {
		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
	
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler({EmployeeAlreadyExistsException.class})
	public ErrorResponseDto handleEmployeeAlreadyExistsError(Exception ex, HttpServletRequest request) {
		return new ErrorResponseDto(new Date(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({Exception.class})
	public ErrorResponseDto handleDefaultException(Exception ex, HttpServletRequest request) {
		return new ErrorResponseDto(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
	
}
