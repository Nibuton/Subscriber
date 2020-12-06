package com.nibuton.intech.subscriber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Message saveMessage(Message message) {
		
		Message answer = null;
		
		if (message instanceof Purchase) {
			answer = purchaseJpaRepository.save((Purchase) message);
			
		}
		else if (message instanceof Subscription) {
			answer = subscriptionJpaRepository.save((Subscription) message);
		}
		return answer;
	}

}
