package com.agudelo.service;

public interface LoginAttemptService {

	void loginSucceeded(String key);

	void loginFailed(String key);

	boolean isBlocked(String key);

	int getRemainingAttempts(String key);
}
