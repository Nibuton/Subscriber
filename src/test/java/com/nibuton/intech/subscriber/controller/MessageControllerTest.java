package com.nibuton.intech.subscriber.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.nibuton.intech.subscriber.service.MessageService;

@WebMvcTest
@AutoConfigureMockMvc
class MessageControllerTest {
	
	@MockBean
	MessageService messageService;
    
    @Autowired
    MessageController messageController;

    @Autowired
    private MockMvc mockMvc;
	
	@Test
	public void whenPostRequestAndValidMessagethenCorrectResponse() throws Exception {
	    String msg = "{\"id\":0,\"msisdn\":1,\"timestamp\":100,\"action\":\"PURCHASE\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/")
	      .content(msg)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void whenPostRequestAndInvalidMessagethenCorrectResponse() throws Exception {
		String invalidId = "{\"id\":-1,\"msisdn\":1,\"timestamp\":100,\"action\":\"PURCHASE\"}";
		String invalidMsisdn = "{\"id\":1,\"msisdn\":-1,\"timestamp\":100,\"action\":\"PURCHASE\"}";
		String invalidAction = "{\"id\":1,\"msisdn\":-1,\"timestamp\":100,\"action\":\"\"}";
		
	    mockMvc.perform(MockMvcRequestBuilders.post("/")
	      .content(invalidId)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isBadRequest());
	    
	    mockMvc.perform(MockMvcRequestBuilders.post("/")
	  	      .content(invalidMsisdn)
	  	      .contentType(MediaType.APPLICATION_JSON))
	  	      .andExpect(MockMvcResultMatchers.status().isBadRequest());
	    
	    mockMvc.perform(MockMvcRequestBuilders.post("/")
		  	      .content(invalidAction)
		  	      .contentType(MediaType.APPLICATION_JSON))
		  	      .andExpect(MockMvcResultMatchers.status().isBadRequest());
	    }

}
