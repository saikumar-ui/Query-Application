package com.sevenEleven.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired
;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sevenEleven.userservice.exception.UserAlreadyExistsException;
import com.sevenEleven.userservice.exception.UserNotFoundException;
import com.sevenEleven.userservice.model.User;
import com.sevenEleven.userservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@HystrixCommand(fallbackMethod = "fallback_addUser", commandProperties = {
	   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
	   @HystrixProperty(name = "circuitBreaker.requestVolumethreshold", value = "5"),
	   @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
	   @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "6000"),
	})
	@PostMapping("/signup")
	public void addUser(@RequestBody User newUser) throws UserAlreadyExistsException{
		userService.addUser(newUser);
	}
	
	public String fallback_addUser() {
		return "Request fails. service takes long time to response";
	}
	
	@DeleteMapping("deleteUser/{userId}")
	public void deleteUser(@PathVariable Integer userId) throws UserNotFoundException {
		userService.deleteUser(userId);
	}
}