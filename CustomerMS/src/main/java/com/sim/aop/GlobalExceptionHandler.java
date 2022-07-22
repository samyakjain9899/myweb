package com.sim.aop;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sim.exception.AlreadyActive;
import com.sim.exception.InvalidValuesException;
import com.sim.utlity.ErrorMessage;




@RestControllerAdvice

public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidValuesException.class) 
	public ResponseEntity<ErrorMessage> InvalidExceptionHandler(InvalidValuesException ex) 
	{
		ErrorMessage error = new ErrorMessage();
		 error.setTimstamp(LocalDateTime.now());
	     error.setErrorCode(HttpStatus.NOT_FOUND.value());
	     error.setMessage(ex.getMessage());
	     return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(AlreadyActive.class)
	public ResponseEntity<ErrorMessage> AlreadyActiveExceptionHandler(AlreadyActive ex) 
	{
		 ErrorMessage error = new ErrorMessage();
		 error.setTimstamp(LocalDateTime.now());
	     error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	     error.setMessage(ex.getMessage());
	     return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> InvalidArgumentFormatExceptionHandler(MethodArgumentNotValidException ex) 
	{
		 ErrorMessage error = new ErrorMessage();
		 error.setTimstamp(LocalDateTime.now());
	     error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	     error.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
                 .collect(Collectors.joining(", ")));
	     return new ResponseEntity<>(error, HttpStatus.OK);
	}
}
