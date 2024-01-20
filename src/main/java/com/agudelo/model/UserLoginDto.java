package com.agudelo.model;

import lombok.Data;

@Data
public class UserLoginDto {
	private String username;
	private String password;
	private String passwordHash;

	// Constructors, Getters, and Setters
}
