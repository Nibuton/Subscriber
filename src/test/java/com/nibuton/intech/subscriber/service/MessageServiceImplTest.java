package com.nibuton.intech.subscriber.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.nibuton.intech.subscriber.entity.Message;
import com.nibuton.intech.subscriber.entity.Purchase;
import com.nibuton.intech.subscriber.entity.Subscription;
import com.nibuton.intech.subscriber.repo.PurchaseJpaRepository;
import com.nibuton.intech.subscriber.repo.SubscriptionJpaRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MessageServiceImplTest {

	    @InjectMocks
	    private MessageServiceImpl messageService;

	    @Mock
	    private PurchaseJpaRepository purchaseJpaRepository;
	    
	    @Mock
	    private SubscriptionJpaRepository subscriptionJpaRepository;
	    
	    Message purchaseMessage;
	    Message subscriptionMessage;
	    
		@Test
		void whenSaveMessageThenRepositorySuccessfullyCalled() {
	    	Message purchaseMessage = new Purchase(1,1,new Timestamp(System.currentTimeMillis()),"PURCHASE");
	    	Message subscriptionMessage = new Subscription(1,1,new Timestamp(System.currentTimeMillis()),"SUBSCRIPTION");
	    	Mockito.when(purchaseJpaRepository.save(Mockito.any())).thenReturn(purchaseMessage);
	    	Mockito.when(subscriptionJpaRepository.save(Mockito.any())).thenReturn(subscriptionMessage);
			Message purchaseAnswer = messageService.saveMessage(purchaseMessage);
			assertNotNull(purchaseAnswer);
			assertTrue(purchaseAnswer.getAction().equals("PURCHASE"));
			Message subscriptionAnswer = messageService.saveMessage(subscriptionMessage);
			assertNotNull(subscriptionAnswer);
			assertTrue(subscriptionAnswer.getAction().equals("SUBSCRIPTION"));
		}

}
