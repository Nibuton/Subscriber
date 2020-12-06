package com.nibuton.intech.subscriber.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.nibuton.intech.subscriber.service.MessageServiceImpl;

@Configuration
public class SubscriberConfig{
	
	@Bean
	CommandLineRunner initDatabase(MessageServiceImpl messageServiceImpl) {
	    return args -> {
	    };
	  }
}
