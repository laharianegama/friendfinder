package com.abc.friendfinder.entity;

//import java.time.Date;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "user_tbl")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	@NotNull
	@Size(max = 65)
	@Column(name = "first_name")
	private String firstName;

	@Size(max = 65)
	@Column(name = "last_name")
	private String lastName;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Email
	@Column(unique = true) // uniques email for every user
	private String email;

	@Pattern(regexp = "(0|91)?[7-9][0-9]{9}") // starts with 0 or 91 and has 9 other numbers
	private String mobile;

	private String school;

	private String college;

	@NotNull
	@Column(unique = true)
	private String username;

	@NotNull
	private String password;

	private String status;

	@OneToOne
	private Address address;

	// user can have multiple posts and a post belongs to single user
	@OneToMany
	private Set<Post> posts;

	// user can add multiple complaints but a complaint belongs to single user
	@OneToMany
	private Set<Complaint> complaints;

	// user can add multiple comments but a comment belongs to single user
	@OneToMany
	private Set<Comment> comments;

	// user can like many posts but a like belongs to single user
	@OneToMany
	private Set<Likes> likes;

	// a user can send many requests
	@OneToMany
	private Set<FriendReq> friendreq;

	public User() {

	}

	public User(@NotNull @Size(max = 65) String firstName, @Size(max = 65) String lastName, Date dob,
			@Email @Size(max = 100) String email, @Pattern(regexp = "(0|91)?[7-9][0-9]{9}") String mobile,
			String school, String college, @Size(max = 128) String username, @Size(max = 128) String password,
			String status, Address address, Set<Post> posts, Set<Complaint> complaints, Set<Comment> comments,
			Set<Likes> likes, Set<FriendReq> friendreq) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.school = school;
		this.college = college;
		this.username = username;
		this.password = password;
		this.status = status;
		this.address = address;
		this.posts = posts;
		this.complaints = complaints;
		this.comments = comments;
		this.likes = likes;
		this.friendreq = friendreq;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Likes> getLikes() {
		return likes;
	}

	public void setLikes(Set<Likes> likes) {
		this.likes = likes;
	}

	public Set<FriendReq> getFriendreq() {
		return friendreq;
	}

	public void setFriendreq(Set<FriendReq> friendreq) {
		this.friendreq = friendreq;
	}

}
