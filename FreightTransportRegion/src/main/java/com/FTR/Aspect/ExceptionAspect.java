package com.FTR.Aspect;
import com.FTR.util.ErrorMessage;
import com.FTR.exceptions.*;


import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class ExceptionAspect {
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(HarborNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleHarborNotFoundException(HarborNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/ftr");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(TreminalNotAvailableException.class)
	public ResponseEntity<ErrorMessage> handleTreminalNotAvailableException(TreminalNotAvailableException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/ftr");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(WorkItemAssignFailException.class)
	public ResponseEntity<ErrorMessage> handleWorkItemAssignFailException(WorkItemAssignFailException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/ftr");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(WorkItemNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleWorkItemNotFoundException(WorkItemNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/ftr");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/ftr");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
}