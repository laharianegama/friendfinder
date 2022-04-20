package com.abc.friendfinder.service;

import java.util.List;

import com.abc.friendfinder.entity.Comment;
import com.abc.friendfinder.entity.FriendReq;
import com.abc.friendfinder.entity.Friends;
import com.abc.friendfinder.entity.Likes;
import com.abc.friendfinder.entity.Post;
import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.exception.PostNotFoundException;
import com.abc.friendfinder.exception.UserNotFoundException;

public interface IUserService {

	public FriendReq sendFriendRequest(FriendReq req) throws UserNotFoundException;

	public Friends acceptFriendRequest(Friends req);

	public List<FriendReq> viewAllReceivedFriendReqest();

	public List<User> searchFriendByName(String name);

	public Post createPost(Post post);

	public Comment addComment(Comment comment, long id) throws PostNotFoundException;

	public Likes likePost(Likes like, long id) throws PostNotFoundException;

}
