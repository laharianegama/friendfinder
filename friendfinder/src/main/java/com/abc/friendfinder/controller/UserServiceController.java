package com.abc.friendfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.abc.friendfinder.entity.Comment;
import com.abc.friendfinder.entity.FriendReq;
import com.abc.friendfinder.entity.Friends;
import com.abc.friendfinder.entity.Likes;
import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.entity.Post;
import com.abc.friendfinder.exception.UserNotFoundException;
import com.abc.friendfinder.exception.PostNotFoundException;
import com.abc.friendfinder.service.IUserService;

//map all user requests to this controller
@RestController
@RequestMapping("/user")
public class UserServiceController {
	
	@Autowired 
	private IUserService userService;
	
	//user sends friend request
	@PostMapping("/sendrequest")
	public FriendReq sendRequest(@RequestBody FriendReq friendReq) throws UserNotFoundException {
		return userService.sendFriendRequest(friendReq);	
	}
	
	//user accepts friendrequest
	@PutMapping("/acceptrequest")
	public Friends acceptRequest(@RequestBody Friends friends) throws UserNotFoundException{
		return userService.acceptFriendRequest(friends);
	}
	
	//user all friendrequests
	@GetMapping("/viewrequests")
	public List<FriendReq> viewRequests(){
		return userService.viewAllReceivedFriendReqest();
	}
	
	//user searches for another user by username
	@GetMapping("/searchfriend/{name}")
	public List<User> searchByName(@PathVariable String name)throws UserNotFoundException{
		return userService.searchFriendByName(name);
	}
	
	//user post
	@PostMapping("/post")
	public Post post(@RequestBody Post post)throws PostNotFoundException{
		return userService.createPost(post);
	}
	
	//user comments on a post 
	@PostMapping("/comment")
	public Comment addaComment(@RequestBody Comment comment)throws PostNotFoundException {
		return userService.addComment(comment,comment.getPost().getId());
	}
	
	//user likes a post
	@PostMapping("/like")
	public Likes likeaPost(@RequestBody Likes likes) throws PostNotFoundException{
		return userService.likePost(likes,likes.getPost().getId());
	}
	
	

}
