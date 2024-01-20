package com.agudelo.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agudelo.helper.UsernameSanitizer;
import com.agudelo.helper.UsernameValidator;
import com.agudelo.repository.UserRepository;
import com.agudelo.service.AuthenticationService;
import com.agudelo.service.LoginAttemptService;

@Service
public class AuthenticationDelegate {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginAttemptService simpleLoginAttemptServiceImpl;

	// Any other services you might need

	public boolean processAuthentication(String username, String password, String passwordHash) {
		// You can add more business logic here, like logging, additional validation,
		// etc.
		boolean isAuthenticated = false;
		final String key = username;
		final boolean isBlocked = this.simpleLoginAttemptServiceImpl.isBlocked(key);
		if (!isBlocked) {
			final String sanitizedUsername = UsernameSanitizer.sanitizeUsername(username);

			if (!UsernameSanitizer.isSanitizationChangedUsername(username, sanitizedUsername)) {
				if (UsernameValidator.isValidUsername(username)) {
					isAuthenticated = this.authenticationService.authenticate(username, password, passwordHash);
				}

			}

			if (isAuthenticated) {
				this.simpleLoginAttemptServiceImpl.loginSucceeded(key);
			} else {
				this.simpleLoginAttemptServiceImpl.loginFailed(key);
			}
		}
		return isAuthenticated;

	}


	// Other methods related to authentication, like registration, password reset,
	// etc.
}
