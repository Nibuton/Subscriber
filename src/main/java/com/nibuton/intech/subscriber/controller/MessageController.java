package com.nibuton.intech.subscriber.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.nibuton.intech.subscriber.entity.Message;
import com.nibuton.intech.subscriber.entity.Purchase;
import com.nibuton.intech.subscriber.service.MessageServiceImpl;

@RestController
@RequestMapping("/")
public class MessageController {
	
	private MessageServiceImpl messageServiceImpl;
	
	@Autowired
	public MessageController(MessageServiceImpl messageServiceImpl) {
		this.messageServiceImpl = messageServiceImpl;
	}
	
	@RequestMapping
	public void save(@RequestBody @Valid Message message) {
		messageServiceImpl.saveMessage(message);
	}
}
