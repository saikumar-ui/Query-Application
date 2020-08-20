package com.sevenEleven.queryservice.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sevenEleven.queryservice.QueryServiceApplication;


@Entity
@Table(name = "user")
public class User {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(QueryServiceApplication.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private Integer id;
	
	@Column(name = "us_username")
	private String username;
	
	@Column(name = "us_password")
	private String password;
	
	@Column(name = "us_email")
	private String email;
	
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
		LOGGER.debug("Inside userId getter method");
		return id;
	}

	public void setId(Integer id) {
		LOGGER.debug("Inside userId setter method");
		this.id = id;
	}

	public String getUsername() {
		LOGGER.debug("Inside username setter method");
		return username;
	}

	public void setUsername(String username) {
		LOGGER.debug("Inside username getter method");
		this.username = username;
	}

	public String getPassword() {
		LOGGER.debug("Inside UserPassword getter method");
		return password;
	}

	public void setPassword(String password) {
		LOGGER.debug("Inside UserPassword setter method");
		this.password = password;
	}
	
	public String getEmail() {
		LOGGER.debug("Inside UserEmail getter method");
		return email;
	}

	public void setEmail(String email) {
		LOGGER.debug("Inside UserEmail setter method");
		this.email = email;
	}
	
	public String getRole() {
		LOGGER.debug("Inside UserRole getter method");
		return role;
	}

	public void setRole(String role) {
		LOGGER.debug("Inside UserRole setter method");
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", password=" + password + ",emai=" + email + ", role=" + role + "]";
	}
}