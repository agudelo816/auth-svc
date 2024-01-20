package com.agudelo.service;

public interface AuthenticationService {
	boolean authenticate(String username, String password, String passwordHash);

	boolean logoutUser(String refreshToken);
}
