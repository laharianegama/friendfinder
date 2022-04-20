package com.abc.friendfinder.service;

import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.exception.UserNotFoundException;

public interface IAuthenticationService {

	public User register(User user);

	public User login(User user) throws UserNotFoundException;

	public boolean logout();

}
