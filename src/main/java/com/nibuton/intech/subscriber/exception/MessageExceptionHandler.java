package com.nibuton.intech.subscriber.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MessageExceptionHandler {

	Logger logger = LoggerFactory.getLogger(MessageExceptionHandler.class);
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
	public ResponseEntity<ExceptionResponse>
		handleHttpMessageNotReadableException(Exception ex){
			
			ExceptionResponse response = new ExceptionResponse();
			response.setMessage(ex.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setTimestamp(System.currentTimeMillis());
			ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			logger.error(responseEntity.toString());
			return responseEntity;
	
	}


}
