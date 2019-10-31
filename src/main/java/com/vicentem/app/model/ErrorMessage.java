package com.vicentem.app.model;

import java.time.LocalDateTime;

public class ErrorMessage {
	private String message;
	private LocalDateTime timestamp;

	public ErrorMessage(LocalDateTime timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
