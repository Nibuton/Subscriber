package com.nibuton.intech.subscriber.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nibuton.intech.subscriber.entity.Message;
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
	
	Logger logger = LoggerFactory.getLogger(MessageController.class);
	
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
		ResponseEntity<Message> response = new ResponseEntity<Message>(answer,HttpStatus.OK);
		logger.info(response.toString());
		return new ResponseEntity<Message>(answer,HttpStatus.OK);
	}
	
	
}
