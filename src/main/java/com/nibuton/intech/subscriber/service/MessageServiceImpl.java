package com.nibuton.intech.subscriber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.nibuton.intech.subscriber.entity.Message;
import com.nibuton.intech.subscriber.entity.Purchase;
import com.nibuton.intech.subscriber.entity.Subscription;
import com.nibuton.intech.subscriber.repo.PurchaseJpaRepository;
import com.nibuton.intech.subscriber.repo.SubscriptionJpaRepository;

@Service
public class MessageServiceImpl implements MessageService{
	
	PurchaseJpaRepository purchaseJpaRepository;
	SubscriptionJpaRepository subscriptionJpaRepository;
	
	@Autowired
	public MessageServiceImpl(PurchaseJpaRepository purchaseJpaRepository, SubscriptionJpaRepository subscriptionJpaRepository) {
		this.purchaseJpaRepository = purchaseJpaRepository;
		this.subscriptionJpaRepository = subscriptionJpaRepository;
	}
	
	@Override
	public void saveMessage(Message message) {
		
		if (message instanceof Purchase) {
			purchaseJpaRepository.save((Purchase) message);
		}
		else if (message instanceof Subscription) {
			subscriptionJpaRepository.save((Subscription) message);
		}
	}

}
