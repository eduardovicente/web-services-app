package com.vicentem.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vicentem.app.model.ErrorMessage;

@ControllerAdvice
public class ExceptionsManager extends ResponseEntityExceptionHandler{
		
	@ExceptionHandler(value = {UserNotFoundException.class, Exception.class})
	public ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
