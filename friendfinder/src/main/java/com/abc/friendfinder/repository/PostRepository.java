package com.abc.friendfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.friendfinder.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
