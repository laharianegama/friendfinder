package com.abc.friendfinder.entity;

import java.io.Serializable;

import java.util.Date;
//import java.time.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "poll_tbl")
public class Poll implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String question;

	@Column
	@ElementCollection(targetClass = String.class) // used to map non-entities
	private List<String> answers;

	@Temporal(TemporalType.DATE)
	private Date createdOn;

	public Poll() {
	}

	public Poll(String question, List<String> answers, Date createdOn) {
		this.question = question;
		this.answers = answers;
		this.createdOn = createdOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
