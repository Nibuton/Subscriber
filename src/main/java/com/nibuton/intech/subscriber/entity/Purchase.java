package com.nibuton.intech.subscriber.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Класс для PURCHASE сообщений
 * @author nibuton
 *
 */
@Entity
@Table(name = "purchase")
public class Purchase extends Message {
	
	public Purchase() {
		super();
	}

	public Purchase(int messageId, int msisdn, Timestamp tstmp, String action) {
		super(messageId, msisdn, tstmp, action);
	}
	
}
