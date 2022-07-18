package com.infy.customer.aspect;

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

import com.infy.customer.exception.AadharNumberInvalidException;
import com.infy.customer.exception.CustomerNotFoundException;
import com.infy.customer.exception.CustomerValidationFailedException;
import com.infy.customer.exception.DateOfBirthInvalidException;
import com.infy.customer.exception.EmailAddressInvalidException;
import com.infy.customer.exception.FirstNameLastNameInvalidException;
import com.infy.customer.exception.InvalidCustomerAddressIdException;
import com.infy.customer.exception.InvalidCustomerAddressSimDetailsException;
import com.infy.customer.exception.SimAlreadyActiveException;
import com.infy.customer.exception.SimIdNotFoundException;
import com.infy.customer.util.ErrorMessage;

@RestControllerAdvice
public class ExceptionAspect {
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(InvalidCustomerAddressIdException.class)
	public ResponseEntity<ErrorMessage> handleInvalidCustomerAddressIdException(InvalidCustomerAddressIdException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(SimIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleSimIdNotFoundException(SimIdNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(CustomerValidationFailedException.class)
	public ResponseEntity<ErrorMessage> handleCustomerValidationFailedException(CustomerValidationFailedException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(EmailAddressInvalidException.class)
	public ResponseEntity<ErrorMessage> handleEmailAddressInvalidException(EmailAddressInvalidException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleCustomerNotFoundException(CustomerNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(SimAlreadyActiveException.class)
	public ResponseEntity<ErrorMessage> handleSimAlreadyActiveException(SimAlreadyActiveException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(InvalidCustomerAddressSimDetailsException.class)
	public ResponseEntity<ErrorMessage> handleInvalidCustomerAddressSimDetailsException(InvalidCustomerAddressSimDetailsException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(DateOfBirthInvalidException.class)
	public ResponseEntity<ErrorMessage> handleDateOfBirthInvalidException(DateOfBirthInvalidException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(FirstNameLastNameInvalidException.class)
	public ResponseEntity<ErrorMessage> handleFirstNameLastNameInvalidException(FirstNameLastNameInvalidException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(AadharNumberInvalidException.class)
	public ResponseEntity<ErrorMessage> handleAadharNumberInvalidException(AadharNumberInvalidException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
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
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorMessage> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(environment.getProperty("dob_format"));
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception e) {
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorMessage.setMessage(e.getMessage());
		errorMessage.setUrl("/customer");
		ResponseEntity<ErrorMessage> responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.OK);
		return responseEntity;
	}
}