package com.example.sree.cloud.currencyexchangeservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotfoundExceptionto extends RuntimeException {

	public NotfoundExceptionto(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
