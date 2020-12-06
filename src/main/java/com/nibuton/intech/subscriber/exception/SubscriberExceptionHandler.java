package com.nibuton.intech.subscriber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SubscriberExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({HttpMessageNotReadableException.class,MethodArgumentNotValidException.class})
	public ResponseEntity<ExceptionResponse>
		handleInvalidRequestException(Exception ex){
			
			ExceptionResponse response = new ExceptionResponse();
			response.setMessage(ex.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setTimestamp(System.currentTimeMillis());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	
	}

}
