package com.nibuton.intech.subscriber.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.istack.NotNull;

/**
 * Абстрактный класс, содержащий всю логику сущности сообщения. Создан, чтобы не дублировать код отдельно 
 * для PURCHASE и SUBSCRIPTION сообщений
 * @author nibuton
 *
 */
@MappedSuperclass
@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME,
		  include = JsonTypeInfo.As.PROPERTY, property = "action",
		  visible = true
		)
@JsonSubTypes({
		    @JsonSubTypes.Type(value = Purchase.class, name = "PURCHASE"),
		    @JsonSubTypes.Type(value = Subscription.class, name = "SUBSCRIPTION")
		})
public abstract class Message{
	
	@Id
	@Min(0)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Min(0)
	@JsonProperty(value = "id")
	@Column(name = "message_id")
	private int messageId;
	
	@NotNull
	@Min(0)
	@Column(name = "msisdn")
	private int msisdn;
	
	@NotNull
	@JsonProperty(value = "timestamp")
	@Column(name = "tstmp")
	private Timestamp tstmp;
	
	@NotBlank
	@Transient
	private String action;

	public Message() {
		// TODO Auto-generated constructor stub
	}

	public Message(int messageId, int msisdn, Timestamp tstmp, String action) {
		super();
		this.messageId = messageId;
		this.msisdn = msisdn;
		this.tstmp = tstmp;
		this.action= action;
	}


	public int getMessageId() {
		return messageId;
	}


	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}


	public int getMsisdn() {
		return msisdn;
	}


	public void setMsisdn(int msisdn) {
		this.msisdn = msisdn;
	}


	public Timestamp getTstmp() {
		return tstmp;
	}


	public void setTstmp(Timestamp tstmp) {
		this.tstmp = tstmp;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", messageId=" + messageId + ", msisdn=" + msisdn + ", tstmp=" + tstmp
				+ ", action=" + action + "]";
	}
	

}
