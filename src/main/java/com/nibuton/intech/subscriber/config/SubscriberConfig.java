package com.nibuton.intech.subscriber.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import com.nibuton.intech.subscriber.service.MessageServiceImpl;

@Configuration
public class SubscriberConfig{
	
	@Bean
	CommandLineRunner initDatabase(MessageServiceImpl messageServiceImpl) {
	    return args -> {
	    };
	  }
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    loggingFilter.setIncludeHeaders(false);
	    return loggingFilter;
	}
}
