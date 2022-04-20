package com.abc.friendfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.abc.friendfinder.entity.User;

//repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects

@Repository
public interface AdminRepository extends JpaRepository<User, Long> {

}
