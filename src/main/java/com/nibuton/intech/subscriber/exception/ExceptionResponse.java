package com.nibuton.intech.subscriber.exception;

public class ExceptionResponse {
	
	private int status;
	private String message;
	private Long Timestamp;
	

	public ExceptionResponse() {
	}
	
	public ExceptionResponse(int status, String message, Long timestamp) {
		super();
		this.status = status;
		this.message = message;
		Timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Long getTimestamp() {
		return Timestamp;
	}


	public void setTimestamp(Long timestamp) {
		Timestamp = timestamp;
	}
	
	

}
