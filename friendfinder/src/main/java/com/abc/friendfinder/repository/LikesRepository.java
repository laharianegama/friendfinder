package com.abc.friendfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.friendfinder.entity.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

}
