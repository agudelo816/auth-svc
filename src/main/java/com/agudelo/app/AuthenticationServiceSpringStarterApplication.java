package com.agudelo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationServiceSpringStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceSpringStarterApplication.class, args);
	}

}
/**
 * Authentication Flow Login:
 * 
 * User sends login credentials. System validates credentials and generates JWT
 * access and refresh tokens. Tokens are sent back to the user. Accessing
 * Protected Resources:
 * 
 * For each request, the access token is sent in the HTTP Authorization header.
 * The token is validated (checked for integrity and expiry). If valid, the user
 * is granted access to the requested resource. Token Refresh:
 * 
 * When the access token expires, the client sends the refresh token to the
 * token refresh endpoint. The refresh token is validated, and a new access
 * token (and optionally a new refresh token) is issued. Logout:
 * 
 * User sends a request to log out with the refresh token. The refresh token is
 * invalidated in the database, preventing further use for generating new access
 * tokens.
 **/