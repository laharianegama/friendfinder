package com.abc.friendfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.exception.UserNotFoundException;
import com.abc.friendfinder.service.IAuthenticationService;


//Mapping all authentication requests to authenticationSeviceController
@RestController
@RequestMapping(value="/authentication")
public class AuthenticationServiceController {
	
	@Autowired
	private IAuthenticationService iauthservice;
	
	//Admin Registration when body provided
	@RequestMapping(value="/admin/register",method=RequestMethod.POST)
	public ResponseEntity<Object> RegisterAdmin(@RequestBody User user) {
		return new ResponseEntity<>(iauthservice.register(user), HttpStatus.OK);
	}
	
	//Admin login providing the body
	@RequestMapping(value="/admin/login",method=RequestMethod.PUT)
	public ResponseEntity<Object> loginAdmin(@RequestBody User user) throws UserNotFoundException{
		return new ResponseEntity<>(iauthservice.login(user), HttpStatus.OK);
	}
	
	//Admin logout 
	@RequestMapping(value="/admin/logout",method=RequestMethod.PUT)
	public boolean logoutAdmin(){
		return iauthservice.logout();
	}
	
	//User registration by providing the user body
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	public ResponseEntity<Object> RegisterUser(@RequestBody User user) {
		return new ResponseEntity<>(iauthservice.register(user), HttpStatus.OK);
	}
	
	//User login provided with body
	@RequestMapping(value="/user/login",method=RequestMethod.PUT)
	public ResponseEntity<Object> loginUser(@RequestBody User user) throws UserNotFoundException{
		return new ResponseEntity<>(iauthservice.login(user), HttpStatus.OK);
	}
	
	//User logout 
	@RequestMapping(value="/user/logout",method=RequestMethod.PUT)
	public boolean logoutUser(){
		return iauthservice.logout();
	}
	
	
}
