package com.agudelo.service;

import java.util.Optional;

import com.agudelo.model.User;

public interface UserManagementService {
	Optional<User> findByUsername(String username);

	void invalidateRefreshToken(String refreshToken);
}
