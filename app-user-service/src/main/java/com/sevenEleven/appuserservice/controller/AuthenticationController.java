package com.sevenEleven.appuserservice.controller;

import java.util.Map;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sevenEleven.appuserservice.model.User;
import com.sevenEleven.appuserservice.service.AuthenticationService;
@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;
	

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) throws UsernameNotFoundException{
		return authenticationService.authenticate(authHeader);
	}
	
	@PostMapping("/signup")
	public void addUser(@RequestBody User user) {
			authenticationService.signup(user);
	}

}
