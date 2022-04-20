package com.abc.friendfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.friendfinder.entity.User;

@Repository
public interface AuthenticationRepository extends JpaRepository<User, Long> {

}
