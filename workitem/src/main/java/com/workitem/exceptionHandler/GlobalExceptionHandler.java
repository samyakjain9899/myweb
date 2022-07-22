package com.workitem.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.workitem.util.ErrorMessage;
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> ExceptionHandler(Exception e){
		ErrorMessage error =  new ErrorMessage();
		error.setMessage(e.getMessage());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setUrl("/workitems/?/?");
  	  ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  	  return entity;
    }
}
