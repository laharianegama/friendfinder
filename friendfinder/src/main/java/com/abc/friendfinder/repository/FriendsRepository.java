package com.abc.friendfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.abc.friendfinder.entity.FriendReq;
import com.abc.friendfinder.entity.Friends;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

}
