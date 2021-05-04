package com.cognizant.component.processing.controlller;

import java.util.Date;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cognizant.component.processing.dto.ErrorResponseDto;
import com.cognizant.component.processing.exception.RequestNotFoundException;
import com.cognizant.component.processing.exception.UserNotFoundException;

//
//@RestControllerAdvice
//public class ComponentProcessingErrorController {
//
//	@ResponseStatus(code = HttpStatus.NOT_FOUND)
//	@ExceptionHandler({UserNotFoundException.class})
//	public ErrorResponseDto handleUserNotFoundError(Exception ex, HttpServletRequest request) {
//		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
//	}
//	
//	@ResponseStatus(code = HttpStatus.NOT_FOUND)
//	@ExceptionHandler({RequestNotFoundException.class})
//	public ErrorResponseDto handleRequestNotFoundError(Exception ex, HttpServletRequest request) {
//		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
//	}
//	
//	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler({Exception.class})
//	public ErrorResponseDto handleDefaultException(Exception ex, HttpServletRequest request) {
//		return new ErrorResponseDto(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
//	}	
//	
//	
//}
