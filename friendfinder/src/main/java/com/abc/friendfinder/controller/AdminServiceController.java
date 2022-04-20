package com.abc.friendfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.exception.UserNotFoundException;
import com.abc.friendfinder.service.IAdminServiceImpl;
import com.abc.friendfinder.service.IPollServiceImpl;


//Redirect all Admin requests
@RestController
@RequestMapping("/admin")
public class AdminServiceController {
	
	//enables you to inject the object dependency implicitly.
	@Autowired
	private IAdminServiceImpl adminservice;
	
	//Admin blocks a user when userBody is provided in RequestBody
	@PutMapping("/block")
	public void blockUser(@RequestBody User user)throws UserNotFoundException {
		adminservice.blockUserAccount(user);	
	}
	
	//Admin unblocks a user when userBody is provided in RequestBody
	@PutMapping("/unblock")
	public void unblockUser(@RequestBody User user)throws UserNotFoundException {
		adminservice.unblockUserAccount(user);	
	}
	
	

}
