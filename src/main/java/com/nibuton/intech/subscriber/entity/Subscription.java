package com.nibuton.intech.subscriber.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Класс для SUBSCRIPTION сообщений
 * @author nibuton
 *
 */
@Entity
@Table(name = "subscription")
public class Subscription extends Message {
	
	public Subscription() {
		super();
	}

	public Subscription(int messageId, int msisdn, Timestamp tstmp, String action) {
		super(messageId, msisdn, tstmp, action);
	}
}
