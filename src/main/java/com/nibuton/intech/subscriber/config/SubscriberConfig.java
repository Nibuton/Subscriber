package com.nibuton.intech.subscriber.config;

import java.sql.Timestamp;

import javax.persistence.EntityManager;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.nibuton.intech.subscriber.entity.Message;
import com.nibuton.intech.subscriber.entity.Purchase;
import com.nibuton.intech.subscriber.repo.PurchaseJpaRepository;
import com.nibuton.intech.subscriber.service.MessageServiceImpl;

@Configuration
public class SubscriberConfig{
	
	@Bean
	CommandLineRunner initDatabase(MessageServiceImpl messageServiceImpl) {
	    return args -> {
	    };
	  }

}
