package com.agudelo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agudelo.model.TokenPair;
import com.agudelo.repository.UserRepository;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean authenticate(String username, String password, String passwordHash) {
		final TokenPair tokenPair = this.getTokenPair(username, password);
		return this.userRepository.findByUsername(username)
				.map(user -> user.getPassword().equals(password) && user.getPasswordHash().equals(passwordHash))
				.orElse(false);

	}


	private TokenPair getTokenPair(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logoutUser(String refreshToken) {
		// TODO Auto-generated method stub
		return false;
	}
}
