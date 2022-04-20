package com.abc.friendfinder.entity;

import java.io.Serializable;

import java.util.Date;
//import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "post_tbl")
public class Post implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private long id;

	private String text;

	private String photo;

	@Temporal(TemporalType.DATE)
	private Date postedOn;

	// user can have multiple posts and a post belongs to single user
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
	private List<Comment> comments;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "post")
	private List<Likes> likes;

	public Post() {

	}

	public Post(String text, String photo, Date postedOn, User user, List<Comment> comments, List<Likes> likes) {
		this.text = text;
		this.photo = photo;
		this.postedOn = postedOn;
		this.user = user;
		this.comments = comments;
		this.likes = likes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

}
