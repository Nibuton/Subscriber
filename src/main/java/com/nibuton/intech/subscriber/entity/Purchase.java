package com.nibuton.intech.subscriber.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

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
