package com.abc.friendfinder.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.friendfinder.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

	List<User> findByUsername(String username);

}
