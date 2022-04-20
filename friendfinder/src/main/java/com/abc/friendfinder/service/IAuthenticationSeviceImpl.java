package com.abc.friendfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.exception.UserNotFoundException;
import com.abc.friendfinder.repository.AuthenticationRepository;

@Service
public class IAuthenticationSeviceImpl implements IAuthenticationService {

	private AuthenticationRepository authenticationRepo;

	@Autowired
	public IAuthenticationSeviceImpl(AuthenticationRepository authenticationRepo) {
		this.authenticationRepo = authenticationRepo;
	}

	@Override
	public User register(User user) {
		if (authenticationRepo.existsById(user.getUserId())) {
			System.out.println("User already exists....");
		} else {
			authenticationRepo.saveAndFlush(user);
		}
		return user;
	}

	@Override
	public User login(User user) throws UserNotFoundException {
		if (authenticationRepo.existsById(user.getUserId())) {
			user.setStatus("Loggedin");
			return authenticationRepo.saveAndFlush(user);
		} else {
			throw new UserNotFoundException("Invalid Username or Password");
		}

	}

	@Override
	public boolean logout() {
		System.out.println("Logged Out Successfully........");
		return true;
	}
	
	/*
	 * @Override public User logout(User user) throws UserNotFoundException{
	 * if(authenticationrepo.existsById(user.getUserId())){
	 * user.setStatus("Loggedout"); return authenticationrepo.saveAndFlush(user); }
	 * else { throw new UserNotFoundException("Invalid Username or Password"); } }
	 */
}
