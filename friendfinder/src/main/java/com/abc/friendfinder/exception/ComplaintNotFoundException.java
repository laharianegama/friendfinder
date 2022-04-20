package com.abc.friendfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Complaint Not Found")
public class ComplaintNotFoundException extends Exception {
	public ComplaintNotFoundException(String msg) {
		super(msg);
	}
}
