package com.abc.friendfinder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "friends_tbl")
public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "friend_id")
	private long id;

	private String username;

	@OneToOne
	private FriendReq friendreq;

	public Friends() {
	}

	public Friends(String username, FriendReq friendreq) {
		this.username = username;
		this.friendreq = friendreq;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FriendReq getFriendreq() {
		return friendreq;
	}

	public void setFriendreq(FriendReq friendreq) {
		this.friendreq = friendreq;
	}

}
