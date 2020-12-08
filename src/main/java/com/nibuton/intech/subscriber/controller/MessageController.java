package com.nibuton.intech.subscriber.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nibuton.intech.subscriber.entity.Message;
import com.nibuton.intech.subscriber.exception.ExceptionResponse;
import com.nibuton.intech.subscriber.service.MessageService;
/**
 * Контроллер, принимающий POST запросы сообщений. Передает полученное сообщение сервису сообщений.
 * @author nibuton
 *
 */
@RestController
@RequestMapping("/")
public class MessageController {
	
	/**
	 * Сервис сообщений, содержащий логику
	 */
	private MessageService messageService;
	
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	/**
	 * @param message сообщение принятое через POST запрос
	 * @return ResponseEntity со статусом 200 и сохраненным сообщением
	 */
	@PostMapping
	public ResponseEntity<Message> save(@RequestBody @Valid Message message) {
		Message answer = messageService.saveMessage(message);
		return new ResponseEntity<Message>(answer,HttpStatus.OK);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse>
		handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
			
			ExceptionResponse response = new ExceptionResponse();
			response.setMessage(ex.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			response.setTimestamp(System.currentTimeMillis());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	
	}
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> 
		handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
				ExceptionResponse response = new ExceptionResponse();
				response.setMessage(ex.getMessage());
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				response.setTimestamp(System.currentTimeMillis());
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

			}
	
	
}
