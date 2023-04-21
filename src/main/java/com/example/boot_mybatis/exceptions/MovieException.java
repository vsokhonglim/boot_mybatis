package com.example.boot_mybatis.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class MovieException {
	private final String message;

	private final HttpStatus httpstatus;
	private final ZonedDateTime timestamp;
	public MovieException(String message, HttpStatus httpstatus, ZonedDateTime timestamp) {
		super();
		this.message = message;
		
		this.httpstatus = httpstatus;
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
	
}
