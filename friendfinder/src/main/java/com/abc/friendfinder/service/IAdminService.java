package com.abc.friendfinder.service;

import com.abc.friendfinder.entity.User;

public interface IAdminService {

	public void unblockUserAccount(User user);

	public void blockUserAccount(User user);

}
