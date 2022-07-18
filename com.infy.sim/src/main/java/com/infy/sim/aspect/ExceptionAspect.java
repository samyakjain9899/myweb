package com.infy.sim.aspect;

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

import com.infy.sim.exception.SimAlreadyActiveException;
import com.infy.sim.exception.SimIdNotFoundException;
import com.infy.sim.exception.SimOfferNotFoundException;
import com.infy.sim.exception.SimServiceNumberInvalidException;
import com.infy.sim.util.ErrorMessage;

@RestControllerAdvice
public class ExceptionAspect {
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(SimOfferNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleSimOfferNotFoundException(SimOfferNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/sim");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(SimServiceNumberInvalidException.class)
	public ResponseEntity<ErrorMessage> handleSimServiceNumberInvalidException(SimServiceNumberInvalidException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/sim");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(SimIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleSimIdNotFoundException(SimIdNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/sim");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(SimAlreadyActiveException.class)
	public ResponseEntity<ErrorMessage> handleSimAlreadyActiveException(SimAlreadyActiveException e) {
		ErrorMessage em = new ErrorMessage();
		em.setStatusCode(HttpStatus.BAD_REQUEST.value());
		em.setMessage(e.getMessage());
		em.setUrl("/sim");
		ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(em, HttpStatus.OK);
		return entity;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/sim");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		List<ObjectError> s = e.getBindingResult().getAllErrors();
		String msg = s.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
		errorMessage.setMessage(msg);
		errorMessage.setUrl("/sim");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/sim");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
}