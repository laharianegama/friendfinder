package com.abc.friendfinder.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity // specifies that the class is an entity and is mapped to a database table.
@Table(name = "address_tbl") // specifies the name of the database table to be used for mapping

//If an entity instance is to be passed by value as a detached object we need to implement serializable
public class Address implements Serializable {

	@Id // indicates the member field below is the primary key of current entity.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // configure the way of increment of the specified column
	private long id;

	private String city;

	private String state;

	private String pincode;

	private String country;

	// an address belongs to one user and a user has single address
	@OneToOne
	private User user;

	public Address() {

	}

	public Address(String city, String state, String pincode, String country, User user) {
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
