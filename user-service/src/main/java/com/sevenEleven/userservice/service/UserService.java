package com.sevenEleven.userservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevenEleven.userservice.exception.UserAlreadyExistsException;
import com.sevenEleven.userservice.exception.UserNotFoundException;
import com.sevenEleven.userservice.model.User;
import com.sevenEleven.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public User getUser(String username) throws UserNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			return user;
		}
	}

	@Transactional
	public void addUser(User newUser) throws UserAlreadyExistsException {
		User user = userRepository.findByUsername(newUser.getUsername());
		if (user == null) {
			String password = newUser.getPassword();
			user.setPassword(passwordEncoder().encode(password));
			user.setRole("USER");
			userRepository.save(user);
		} else {
			throw new UserAlreadyExistsException();
		}
	}

	@Transactional
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Transactional
	public void deleteUser(Integer userId) throws UserNotFoundException {
		try {
			userRepository.deleteById(userId);
		} catch (Exception userNotFoundException) {
			throw new UserNotFoundException();
		}
	}
}