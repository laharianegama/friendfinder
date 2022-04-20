package com.abc.friendfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.friendfinder.entity.Comment;
import com.abc.friendfinder.entity.FriendReq;
import com.abc.friendfinder.entity.Friends;
import com.abc.friendfinder.entity.Likes;
import com.abc.friendfinder.entity.Post;
import com.abc.friendfinder.entity.User;
import com.abc.friendfinder.exception.PostNotFoundException;
import com.abc.friendfinder.exception.UserNotFoundException;
import com.abc.friendfinder.repository.CommentRepository;
import com.abc.friendfinder.repository.FriendReqRepository;
import com.abc.friendfinder.repository.FriendsRepository;
import com.abc.friendfinder.repository.LikesRepository;
import com.abc.friendfinder.repository.PollRepository;
import com.abc.friendfinder.repository.PostRepository;
import com.abc.friendfinder.repository.UserRepository;

@Service
public class IUserServiceImpl implements IUserService {
	private UserRepository userRepo;
	private PostRepository postRepo;
	private CommentRepository commentRepo;
	private LikesRepository likesRepo;
	private FriendReqRepository friendReqRepo;
	private FriendsRepository friendsRepo;

	@Autowired
	public IUserServiceImpl(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo,
			LikesRepository likesRepo, FriendReqRepository friendReqRepo, FriendsRepository friendsRepo) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.commentRepo = commentRepo;
		this.likesRepo = likesRepo;
		this.friendReqRepo = friendReqRepo;
		this.friendsRepo = friendsRepo;
	}

	@Override
	public FriendReq sendFriendRequest(FriendReq req) throws UserNotFoundException {
		if (userRepo.existsById(req.getUser().getUserId())) {
			if (friendReqRepo.existsById(req.getId())) {
				return req;
			} else {
				return friendReqRepo.saveAndFlush(req);
			}
		} else {
			throw new UserNotFoundException("User Not Found");
		}
	}

	@Override
	public Friends acceptFriendRequest(Friends acc) {
		if (friendReqRepo.existsById(acc.getFriendreq().getId())) {
			return friendsRepo.saveAndFlush(acc);
		} else {
			return acc;
		}
	}

	@Override
	public List<FriendReq> viewAllReceivedFriendReqest() {
		return friendReqRepo.findAll();
	}

	@Override
	public List<User> searchFriendByName(String name) {
		return userRepo.findByUsername(name);
	}

	@Override
	public Post createPost(Post post) {
		return postRepo.saveAndFlush(post);
	}

	@Override
	public Comment addComment(Comment comment, long id) throws PostNotFoundException {
		if (postRepo.existsById(id)) {
			return commentRepo.saveAndFlush(comment);
		} else {
			throw new PostNotFoundException("Post Not Found");
		}
	}

	@Override
	public Likes likePost(Likes like, long id) throws PostNotFoundException {
		if (postRepo.existsById(id)) {
			like.setLiked(true);
			return likesRepo.saveAndFlush(like);
		} else {
			throw new PostNotFoundException("Post Not Found");
		}
	}

}
