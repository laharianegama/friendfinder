package com.abc.friendfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.repository.UserRepository;

@Service
public class IAdminServiceImpl implements IAdminService {
	private UserRepository userRepo;

	@Autowired
	public IAdminServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	// service method implementation for unblocking user
	@Override
	public void unblockUserAccount(User user) {
		// TODO Auto-generated method stub
		user.setStatus("Unblocked");
		userRepo.saveAndFlush(user);
	}

	// service method implementation for blocking user
	@Override
	public void blockUserAccount(User user) {
		// TODO Auto-generated method stub
		// userRepo.deleteById(user.getuser_id());
		// user=null;
		user.setStatus("Blocked");
		userRepo.saveAndFlush(user);
	}

}
