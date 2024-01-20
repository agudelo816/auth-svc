package com.agudelo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.agudelo.model.TokenDto;
import com.agudelo.model.TokenRefreshRequest;
import com.agudelo.service.TokenService;

/**
 * Handles requests for new access tokens using the refresh token.
 *
 * @author daniel_agudelo
 *
 */
public class TokenRefreshController {

	@Autowired
	private TokenService tokenService;

	@PostMapping("/v1/token/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody TokenDto tokenDto) {
		// Validate refresh token
		// Generate new access token
		// Optionally generate new refresh token
		// Return new access token
		return null;
	}

	@PostMapping("/v2/token/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody TokenRefreshRequest tokenRefreshRequest) {
		// Logic to validate and process refresh token
		// ...
		final String extractedUsername = "";

		final String newAccessToken = this.tokenService.generateAccessToken(extractedUsername);
		return ResponseEntity.ok(Collections.singletonMap("accessToken", newAccessToken));
	}
}
