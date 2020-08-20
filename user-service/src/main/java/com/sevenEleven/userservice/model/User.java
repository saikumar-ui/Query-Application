package com.sevenEleven.userservice.model;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sevenEleven.userservice.UserServiceApplication;


@Entity
@Table(name = "user")
public class User {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApplication.class);
	
	@NotNull(message = "Id should be a number")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private Integer id;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 30, message = "Invalid user name")
	@Column(name = "us_username")
	private String username;
	
	@NotNull
	@NotBlank
	@Column(name = "us_password")
	private String password;
	
	@NotNull
	@NotBlank
	@Column(name = "us_email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name = "us_role")
	private String role;
	
	public User() {
		super();
	}

	public User(Integer id, String name, String password,String email, String role) {
		super();
		this.id = id;
		this.username = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public Integer getId() {
		LOGGER.info("Inside userId getter method");
		return id;
	}

	public void setId(Integer id) {
		LOGGER.info("Inside userId setter method");
		this.id = id;
	}

	public String getUsername() {
		LOGGER.info("Inside username setter method");
		return username;
	}

	public void setUsername(String username) {
		LOGGER.info("Inside username getter method");
		this.username = username;
	}

	public String getPassword() {
		LOGGER.info("Inside UserPassword getter method");
		return password;
	}

	public void setPassword(String password) {
		LOGGER.info("Inside UserPassword setter method");
		this.password = password;
	}
	
	public String getEmail() {
		LOGGER.info("Inside UserEmail getter method");
		return email;
	}

	public void setEmail(String email) {
		LOGGER.info("Inside UserEmail setter method");
		this.email = email;
	}
	
	public String getRole() {
		LOGGER.info("Inside UserRole getter method");
		return role;
	}

	public void setRole(String role) {
		LOGGER.info("Inside UserRole setter method");
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", password=" + password + ",emai=" + email + ", role=" + role + "]";
	}
}