package com.agudelo.helper;

public class UsernameSanitizer {

	/**
	 * Sanitizes a username by removing unwanted characters. Only allows
	 * alphanumeric characters, dots, underscores, and hyphens.
	 *
	 * @param username The username to be sanitized.
	 * @return A sanitized version of the username.
	 */
	public static String sanitizeUsername(String username) {
		if (username == null) {
			return null;
		}

		// Remove all characters except letters, numbers, dots, underscores, and hyphens
		return username.replaceAll("[^a-zA-Z0-9._-]", "");
	}

	/**
	 * Checks if the sanitized username is different from the raw username.
	 *
	 * @param rawUsername       The original username.
	 * @param sanitizedUsername The sanitized version of the username.
	 * @return true if they are different, false otherwise.
	 */
	public static boolean isSanitizationChangedUsername(String rawUsername, String sanitizedUsername) {
		if (rawUsername == null || sanitizedUsername == null) {
			return false;
		}
		return !rawUsername.equals(sanitizedUsername);
	}
}
/*
 * public static void main(String[] args) { // Example usage final String
 * rawUsername = "user@name!123"; final String sanitizedUsername =
 * sanitizeUsername(rawUsername); System.out.println("Sanitized Username: " +
 * sanitizedUsername); }
 */
/*
 * public static void main(String[] args) { // Example usage String rawUsername
 * = "user@name!123"; String sanitizedUsername = sanitizeUsername(rawUsername);
 * System.out.println("Raw Username: " + rawUsername);
 * System.out.println("Sanitized Username: " + sanitizedUsername);
 *
 * boolean isChanged = isSanitizationChangedUsername(rawUsername,
 * sanitizedUsername);
 * System.out.println("Is Username Changed by Sanitization? " + isChanged); }
 *
 */
