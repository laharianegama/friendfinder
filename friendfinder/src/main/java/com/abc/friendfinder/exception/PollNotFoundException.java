package com.abc.friendfinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Poll Not Found")
public class PollNotFoundException extends Exception {
	public PollNotFoundException(String msg) {
		super(msg);
	}
}
