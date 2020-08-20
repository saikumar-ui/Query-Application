package com.sevenEleven.appuserservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.sevenEleven.appuserservice.model.AppUser;
import com.sevenEleven.appuserservice.model.User;
import com.sevenEleven.appuserservice.repository.UserRepository;
@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("In loadd by username");		
		User user = userRepository.findByEmail(email);
		System.out.println("User info  :" + user);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		} else {
			AppUser newUser = new AppUser(user);
			return newUser;
		}
	}	
}
