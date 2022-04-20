package com.abc.friendfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.friendfinder.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
