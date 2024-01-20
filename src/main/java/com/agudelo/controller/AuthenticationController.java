package com.agudelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agudelo.delegate.AuthenticationDelegate;
import com.agudelo.model.TokenDto;
import com.agudelo.model.UserLoginDto;
import com.agudelo.service.AuthenticationService;

/**
 * Handles login and logout requests. On login, validates user credentials and
 * returns JWT access and refresh tokens. On logout, invalidates the refresh
 * token.
 *
 * @author daniel_agudelo
 *
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationDelegate authenticationDelegate;

	@Autowired
	private AuthenticationService authenticationService;


	@PostMapping("/v1/login")
	public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDto userLoginDto) {

		try {

			final boolean isAuthenticated = this.authenticationDelegate.processAuthentication(
					userLoginDto.getUsername(),
					userLoginDto.getPassword(),

					userLoginDto.getPasswordHash());

			if (isAuthenticated) {
				// Perform any post-authentication actions
				return ResponseEntity.ok("User authenticated successfully");
			}
		} catch (final Exception exc) {
			System.out.println("user authentication failure");

		}

		// Handle authentication failure
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");

	}

	@PostMapping("/v1/logout")
	public ResponseEntity<?> logout(@RequestBody TokenDto tokenDto) {
		// Invalidate refresh token
		// Return logout success message
		return null;
	}

	@PostMapping("/v2/logout")
	public ResponseEntity<?> logoutAuthenticationService(@RequestBody TokenDto tokenDto) {
		this.authenticationService.logoutUser(tokenDto.getRefreshToken());
		return ResponseEntity.ok("Logged out successfully");
	}
}
