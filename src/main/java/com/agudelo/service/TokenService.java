package com.agudelo.service;

import com.agudelo.helper.UserDetails;

public interface TokenService {

	String generateAccessToken(String username);

	String generateRefreshToken(String username);

	boolean validateAccessToken(String token);

	boolean validateRefreshToken(String token);

	UserDetails extractUserDetailsFromAccessToken(String token);
}

/**
 * Responsible for generating and validating tokens. Uses a secret key to sign
 * the JWT and validate incoming JWTs.
 *
 * @author daniel_agudelo
 *
 */
