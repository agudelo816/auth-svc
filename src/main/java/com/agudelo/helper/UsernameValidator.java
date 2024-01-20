package com.agudelo.helper;

import java.util.regex.Pattern;

public class UsernameValidator {

	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9._-]{3,15}$";

	private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

	public static boolean isValidUsername(String username) {
		if (username == null) {
			return false;
		}
		return pattern.matcher(username).matches();
	}
	/*
	 * public static void main(String[] args) { // Test the validator final String
	 * testUsername = "user_name123"; final boolean isValid =
	 * isValidUsername(testUsername); System.out.println("Is valid: " + isValid); }
	 */
}
